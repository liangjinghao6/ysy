package com.orange.ysy.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.orange.ysy.annotation.SwaggerShow;
import com.orange.ysy.entity.ResultBean;
import com.orange.ysy.entity.YsySysFile;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.mapper.YsySysFileMapper;
import com.orange.ysy.util.CreateId;
import com.orange.ysy.util.FileUtil;
import com.orange.ysy.util.IPUtil;
import com.orange.ysy.util.ImageUtil;
import com.orange.ysy.util.MD5Util;
import com.orange.ysy.util.ResultUtil;

import io.swagger.annotations.Api;


@Controller
@RequestMapping("/file")
@Api(description = "文件管理", hidden=true)
@SwaggerShow
public class FileController {
	private static Logger log = LoggerFactory.getLogger(FileController.class);
	
	
	@Value("${orange.ysy.file.upload.path}")
	private String filePath;
	@Value("${orange.ysy.file.type}")
	private String fileType;
	
	@Autowired
	private YsySysFileMapper fileMapper;
	/**
	 * 上传图片
	 * @throws IOException 
	 */
	@RequestMapping("upload")
	@ResponseBody
	public ResultBean upload(@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws IOException {
		try {
			log.info("开始上传文件");
	
	
			YsySysFile ysyFile = new YsySysFile();
	
			String originalFilename = file.getOriginalFilename();
			String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
			String fileName = MD5Util.streamToMd5(file.getInputStream());
	
			boolean isAccessFile = false;
			for (String checkSuffix : StringUtils.split(fileType, ",")) {
				if (StringUtils.equals(checkSuffix, StringUtils.lowerCase(suffix))) {
					isAccessFile = true;
				}
			}
			if(!isAccessFile) {
				return ResultUtil.returnResult(suffix, "文件类型不合法", false);
			}
			ysyFile.setFileId(CreateId.Uuid());
			ysyFile.setRecordStatus(RecordStatus.NORMAL.getValue());
			ysyFile.setFromIp(IPUtil.getIpAddr(request));
			ysyFile.setOrgName(originalFilename);
			ysyFile.setSuffix(suffix);
			ysyFile.setName(fileName);
			fileMapper.insert(ysyFile);
		
			String path = FileUtil.fileUpload(file, filePath, fileName + suffix);
			if (path == null) {
				ysyFile.setRecordStatus(RecordStatus.FAIL.getValue());
				fileMapper.updateByPrimaryKey(ysyFile);
				return ResultUtil.returnResult("", "文件上传失败", false);
			} else {
				ysyFile.setRecordStatus(RecordStatus.SUCCESS.getValue());
				fileMapper.updateByPrimaryKey(ysyFile);
			}
			
			
			return ResultUtil.returnResult(ysyFile, "上传成功");
		} catch (Exception e) {
			return ResultUtil.returnResult(e);
		}
		

	}

	/**
	 * 下载文件
	 * 
	 * @param fileName
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("download/{fileId}")
	public void download(@PathVariable String fileId, HttpServletResponse response) {
		log.info("开始下载图片");
		YsySysFile file = fileMapper.selectByPrimaryKey(fileId);
		String path = filePath + "/" + file.getName() + file.getSuffix();
		if (StringUtils.isNotBlank(path)) {
			FileUtil.download(response, file.getOrgName(), path);
		}
	}

	
	/**
	 * 打印图片
	 */
	@RequestMapping(value = "/print/{imageCode}.{suffix}")
	public void printImage(@PathVariable String imageCode,
			@PathVariable String suffix, 
			HttpServletResponse response, 
			@RequestParam(required = false) Integer width, 
			@RequestParam(required = false) Integer height) {
		log.info("开始显示图片" );
		try {
			String imgPath = filePath + "/" + imageCode + "." + suffix;
			BufferedImage bufImg = ImageUtil.readImage(imgPath);
			if (width == null || height == null || width <= 0 || height <= 0) {
				ImageIO.write(bufImg, suffix, response.getOutputStream());
				bufImg.flush();
				bufImg = null;
			} else {
				BufferedImage bufImgNew = ImageUtil.modifySize(bufImg, width, height);
				ImageIO.write(bufImgNew, suffix, response.getOutputStream());
				bufImg.flush();
				bufImg = null;
				bufImgNew.flush();
				bufImgNew = null;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		log.info("显示图片结束");
	}
	
}
