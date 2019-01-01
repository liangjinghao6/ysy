package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyLnkGoodsImage;
import com.orange.ysy.entity.YsyLnkGoodsImageExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyLnkGoodsImageMapper;
import com.orange.ysy.service.ILnkGoodsImageService;
import com.orange.ysy.util.CreateId;

@Service
public class LnkGoodsImageService implements ILnkGoodsImageService{

	@Autowired
	private YsyLnkGoodsImageMapper lnkgoodsimageMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyLnkGoodsImage lnkgoodsimage = new YsyLnkGoodsImage();
		lnkgoodsimage.setImageId(id);
		return lnkgoodsimageMapper.updateByPrimaryKeySelective(lnkgoodsimage);
	}


	@Override
	public Integer updateLnkGoodsImage(YsyLnkGoodsImage lnkgoodsimage) {
		lnkgoodsimage.setCreateTime(null);
		return lnkgoodsimageMapper.updateByPrimaryKey(lnkgoodsimage);
	}

	@Override
	public Integer addLnkGoodsImage(YsyLnkGoodsImage lnkgoodsimage) {
//		if (StringUtils.isEmpty(lnkgoodsimage.getLnkGoodsImageName()) || StringUtils.isEmpty(lnkgoodsimage.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyLnkGoodsImageExample lnkgoodsimageExample = new YsyLnkGoodsImageExample();
//		lnkgoodsimageExample.createCriteria().andWxEqualTo(lnkgoodsimage.getWx());
//		lnkgoodsimageExample.createCriteria().andLnkGoodsImageNameEqualTo(lnkgoodsimage.getLnkGoodsImageName());
//		List<YsyLnkGoodsImage> lnkgoodsimageCheck = lnkgoodsimageMapper.selectByExample(lnkgoodsimageExample);
//		if (lnkgoodsimageCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		lnkgoodsimage.setImageId(CreateId.Uuid());

		return lnkgoodsimageMapper.insertSelective(lnkgoodsimage);
	}

	@Override
	public PageBean<YsyLnkGoodsImage> findLnkGoodsImage(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyLnkGoodsImage> pageBean = new PageBean<YsyLnkGoodsImage>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyLnkGoodsImageExample lnkgoodsimageExample = new YsyLnkGoodsImageExample();
//		if(StringUtils.isNotEmpty(q)) {
//			lnkgoodsimageExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			lnkgoodsimageExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andLnkGoodsImageNameLike("%" + q + "%");
//		}
		lnkgoodsimageExample.setLimit(pageSize);
		lnkgoodsimageExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = lnkgoodsimageMapper.countByExample(lnkgoodsimageExample);
		List<YsyLnkGoodsImage> list = lnkgoodsimageMapper.selectByExample(lnkgoodsimageExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyLnkGoodsImage detailLnkGoodsImage(String id) {
		return lnkgoodsimageMapper.selectByPrimaryKey(id);
	}

}
