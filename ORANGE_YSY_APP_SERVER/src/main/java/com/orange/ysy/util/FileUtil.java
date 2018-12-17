package com.orange.ysy.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * 	
 * @author jinghao.liang
 *
 */
public class FileUtil {
	private static Logger log = LoggerFactory.getLogger(FileUtil.class);

	
	/**
	 * 获取加密文件名
	 * @param suffix
	 * @return
	 */
	public static String getFileName(String suffix) {
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss_").format(Calendar.getInstance().getTime());
		// 获得三位随机数
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			fileName += random.nextInt(9);
		}
		fileName += suffix;
		return fileName;
	}
	
	/**
	 * 加密文件名是否合法
	 * @param name
	 * @return
	 */
	public static boolean isFileName(String name, String suffix) {
		boolean retval = false;
		String pattern = "^[0-9]{12}\\." + suffix + "$";
		
		retval = name.matches(pattern);
		return retval;
	}
	
	/**
	 * 获取文件目录下的所有文件名
	 * @param path
	 * @return
	 */
	public static List<String> getFileNamesInPath(String path) {
		File file = new File(path);
		if (!file.isDirectory()) {
			log.info("[" + file.getPath() + "]必须是目录");
			return null;
		}
		File[] files = file.listFiles();
		if(files == null) {
			return null;
		}
		List<String> names = new ArrayList<String>();
		for(File f : files) {
			names.add(f.getName());
		}
		return names;
	}
	
	/**
	 * 获取文件目录下的一个文件名
	 * @param path
	 * @return
	 */
	public static String getFileNameInPath(String path) {
		File file = new File(path);
		if (!file.isDirectory()) {
			log.info("[" + file.getPath() + "]必须是目录");
			return null;
		}
		File[] files = file.listFiles();
		if(files == null) {
			return null;
		}
		if(files.length > 0) {
			return files[0].getName();
		} else {
			return null;
		}
	}
	/**
	 * 移动文件路径下的所有文件到另一个文件夹
	 * @param path
	 * @param newpath
	 * @throws IOException 
	 */
	public static void moveAllFileInPath(String path, String newpath) throws IOException {
		File file = new File(path);
		if (!file.isDirectory()) {
			log.info("[" + file.getPath() + "]必须是目录");
			return;
		}
		File[] files = file.listFiles();
		if(files == null) {
			return;
		}
		for(File f : files) {
			moveFile(f, newpath);
		}
	}
	

	
	/**
	 * 移动文件至新目录 如果新目录中已存在此文件名，刚将已存在的文件后缀改为.old 新目录中同时会产生新的文件
	 * 
	 * @param file
	 * @param targetPath
	 * @throws IOException
	 */
	public static void moveFile(File file, String targetPath) throws IOException {
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			byte[] buffer = new byte[1024];
			int length = 0;
			File targetPathFile = new File(targetPath);
			if (!targetPathFile.exists()) {
				targetPathFile.mkdirs();
			}
			
			File targetFile = new File(targetPath + "/" + file.getName());
			if (targetFile.exists()) {
				FileUtil.log.error("[" + targetFile.getAbsolutePath() + "]已经存在，重命名");
				FileUtil.renameFileInSameDir(targetFile, ".old");
				targetFile.delete();
			}
			
			dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(targetPath + "/" + file.getName())));
			dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			while (dataInputStream.available() > 0) {
				length = dataInputStream.read(buffer);
				dataOutputStream.write(buffer, 0, length);
			}
		} catch (Exception e) {
			FileUtil.log.error("[" + file.getName() + "]移动[" + targetPath + "]失败，", e);
			return;
		} finally {
			if (dataOutputStream != null) {
				dataOutputStream.close();
			}
			if (dataInputStream != null) {
				dataInputStream.close();
			}
		}
		FileUtil.log.info("[" + file.getName() + "]已移动到路径[" + targetPath + "]下 ");
		boolean result = file.delete();
		FileUtil.log.info("删除[" + file.getName() + "]返回值[" + result + "]");
	}
	
	/**
	 * 重命名文件下的重名文件
	 * @param file
	 * @param subFix
	 * @return
	 */
	public static File renameFileInSameDir(File file, String subFix) {
		File targetFile = null;
		byte[] buffer = new byte[1024];
		int length = 0;
		DataInputStream dis = null;
		DataOutputStream dao = null;
		try {
			if (file.getName().indexOf(".") <= 0) {
				FileUtil.log.warn("File name error:" + file.getName());
				return null;
			}
			String targetFileName = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(".")) + subFix;

			FileUtil.log.info("Rename:" + file.getName() + " to:" + targetFileName);

			targetFile = new File(targetFileName);
			if (targetFile.exists()) {
				FileUtil.log.warn("File already exist:" + targetFile.getAbsolutePath());
			}

			dao = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(targetFileName)));
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			while (dis.available() > 0) {
				length = dis.read(buffer);
				dao.write(buffer, 0, length);
			}
			dao.close();
			dis.close();
			file.delete();
			FileUtil.log.info("删除原文件: " + file.getAbsolutePath());
		} catch (Exception e) {
			FileUtil.log.warn("备份 同名文件 Error:" + e, e);
		}

		return targetFile;
	}
	
	
    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return 
     */
	public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
	
	/**
	 * 上传文件到服务器
	 * @param file
	 * @param pathtype
	 * @return
	 */
	public static String fileUpload(MultipartFile file, String path) {
	
		String origFileName = file.getOriginalFilename();
		String suffix = origFileName.substring(origFileName.lastIndexOf("."));
		String fileName = getFileName(suffix);
		
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
			return path + targetFile.getName();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	/**
	 * 上传文件到服务器
	 * @param file
	 * @param pathtype
	 * @return
	 */
	public static String fileUpload(MultipartFile file, String path, String fileName) {
		path = path.endsWith("/") ? path : path + "/";
		File targetPath = new File(path);
		if (!targetPath.exists()) {
			targetPath.mkdirs();
		}

		File targetFile = new File(path, fileName);
		try {
			file.transferTo(targetFile);
			return path + targetFile.getName();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	/**
	 * 从服务器下载文件
	 * @param response
	 * @param realName
	 * @param serverFilePath
	 */
	public static void download(HttpServletResponse response, String realName,
			String serverFilePath) {
		FileInputStream is = null;
		OutputStream out = null;
		try{
			is = new FileInputStream(new File(serverFilePath));
			if (is != null) {
				int length = is.available();
				// 设置响应正文的MIME类型
				response.setContentType("application/octet-stream");
				/* 设置head表头 */
				response.setHeader("Content-Length", String.valueOf(length));
				response.setHeader("Content-Disposition", "attachment;filename=\"" + new String(realName.getBytes("utf-8"), "ISO8859-1") + "\"");
				/** 把本地文件中的数据发送给客户 */
				out = response.getOutputStream(); // 获取输出流
				int bytesRead = 0;
				byte[] buffer = new byte[512];
				while ((bytesRead = is.read(buffer)) != -1) {
					out.write(buffer, 0, bytesRead);
				}
				out.flush();
			}
			File serverFile = new File(serverFilePath);
			if(serverFile.isFile()){
				serverFile.delete();
			}
		} catch (Exception e) {
			log.error("下载文件发生异常", e);
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("关闭文件流异常", e);
				}
			}
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					log.error("关闭文件流异常", e);
				}
			}
		}
	}

	public static String getDatePath(String imagePath, Date date) {
		imagePath = imagePath.endsWith("/") ? imagePath : imagePath + "/";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
		return imagePath + sdf.format(date);
	}
}
