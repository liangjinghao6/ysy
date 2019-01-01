package com.orange.ysy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoods;
import com.orange.ysy.entity.YsyGoodsExample;
import com.orange.ysy.entity.YsyLnkGoodsClass;
import com.orange.ysy.entity.YsyLnkGoodsClassExample;
import com.orange.ysy.entity.YsyLnkGoodsImage;
import com.orange.ysy.entity.YsyLnkGoodsImageExample;
import com.orange.ysy.entity.mvo.YsyGoodsMvo;
import com.orange.ysy.enumerate.GoodsImageType;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.mapper.AYsyGoodsMapper;
import com.orange.ysy.mapper.YsyLnkGoodsClassMapper;
import com.orange.ysy.mapper.YsyLnkGoodsImageMapper;
import com.orange.ysy.service.IGoodsService;
import com.orange.ysy.util.ClassUtil;
import com.orange.ysy.util.CreateId;

@Service
public class GoodsService implements IGoodsService{

	@Autowired
	private AYsyGoodsMapper goodsMapper;
	@Autowired
	private YsyLnkGoodsImageMapper goodsImageMapper;
	@Autowired
	private YsyLnkGoodsClassMapper goodsClassMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyGoods goods = new YsyGoods();
		goods.setGoodsId(id);
		goods.setRecordStatus(RecordStatus.DELETE.getValue());
		return goodsMapper.updateByPrimaryKeySelective(goods);
	}


	@Override
	public PageBean<YsyGoods> findGoods(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyGoods> pageBean = new PageBean<YsyGoods>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyGoodsExample goodsExample = new YsyGoodsExample();
		goodsExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			goodsExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			goodsExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andGoodsNameLike("%" + q + "%");
//		}
		goodsExample.setLimit(pageSize);
		goodsExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = goodsMapper.countByExample(goodsExample);
		List<YsyGoods> list = goodsMapper.selectByExample(goodsExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyGoodsMvo detailGoods(String id) throws Exception {
		YsyGoods goods =  goodsMapper.selectByPrimaryKey(id);
		YsyGoodsMvo goodsMvo = new YsyGoodsMvo();
		ClassUtil.fatherToChild(goods, goodsMvo);
		goodsMvo.setClasses(getClassIdByGoodsId(goodsMvo.getGoodsId()));
		goodsMvo.setSimpleImage(getImagesByGoodsId(goodsMvo.getGoodsId(), GoodsImageType.SIMPLE.getValue()));
		goodsMvo.setDetailsImage(getImagesByGoodsId(goodsMvo.getGoodsId(), GoodsImageType.DETAILS.getValue()));
		goodsMvo.setWheelImage(getImagesByGoodsId(goodsMvo.getGoodsId(), GoodsImageType.WHEEL.getValue()));
		goodsMvo.setExtensionImage(getImagesByGoodsId(goodsMvo.getGoodsId(), GoodsImageType.EXTENSION.getValue()));
		return goodsMvo;
	}


	private List<String> getImagesByGoodsId(String goodsId, Short type) {
		YsyLnkGoodsImageExample example1 = new YsyLnkGoodsImageExample();
		example1.createCriteria().andGoodsIdEqualTo(goodsId).andImageTypeEqualTo(type);
		List<YsyLnkGoodsImage> images = goodsImageMapper.selectByExample(example1);
		List<String> imageId = new ArrayList<String>();
		for(YsyLnkGoodsImage img : images) {
			imageId.add(img.getImageId());
		}
		images.clear();
		return imageId;
	}


	private List<String> getClassIdByGoodsId(String goodsId) {
		YsyLnkGoodsClassExample example1 = new YsyLnkGoodsClassExample();
		example1.createCriteria().andGoodsIdEqualTo(goodsId);
		List<YsyLnkGoodsClass> classes = goodsClassMapper.selectByExample(example1);
		List<String> classId = new ArrayList<String>();
		for(YsyLnkGoodsClass cls : classes) {
			classId.add(cls.getClassId());
		}
		classes.clear();
		return classId;
	}


	@Override
	public Integer addGoods(YsyGoodsMvo goods) {
		goods.setGoodsId(CreateId.Uuid());

		goods.setRecordStatus(RecordStatus.NORMAL.getValue());
		Integer count = goodsMapper.insertSelective(goods);
		this.updateGoodsImage(goods.getSimpleImage(), GoodsImageType.SIMPLE.getValue(), goods.getGoodsId());
		this.updateGoodsImage(goods.getDetailsImage(), GoodsImageType.DETAILS.getValue(), goods.getGoodsId());
		this.updateGoodsImage(goods.getWheelImage(), GoodsImageType.WHEEL.getValue(), goods.getGoodsId());
		this.updateGoodsImage(goods.getExtensionImage(), GoodsImageType.EXTENSION.getValue(), goods.getGoodsId());
		this.updateGoodsClasses(goods.getClasses(), goods.getGoodsId());
		return count;
	}


	private void updateGoodsClasses(List<String> classes, String goodsId) {
		YsyLnkGoodsClassExample example = new YsyLnkGoodsClassExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId);
		goodsClassMapper.deleteByExample(example);
		for(String cls : classes) {
			YsyLnkGoodsClass goodsClass = new YsyLnkGoodsClass();
			goodsClass.setClassId(cls);
			goodsClass.setGcId(CreateId.Uuid());
			goodsClass.setGoodsId(goodsId);
			goodsClassMapper.insert(goodsClass);
		}
	}


	private void updateGoodsImage(List<String> imageIds, Short type, String goodsId) {
		YsyLnkGoodsImageExample example = new YsyLnkGoodsImageExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId).andImageTypeEqualTo(type);
		goodsImageMapper.deleteByExample(example);
		for(String imageId : imageIds) {
			YsyLnkGoodsImage goodsImage = new YsyLnkGoodsImage();
			goodsImage.setGiId(CreateId.Uuid());
			goodsImage.setImageId(imageId);
			goodsImage.setImageType(type);
			goodsImage.setGoodsId(goodsId);
			goodsImageMapper.insert(goodsImage);
		}
	}


	@Override
	public Integer updateGoods(YsyGoodsMvo goods) {
		goods.setRecordStatus(null);
		goods.setCreateTime(null);
		goods.setUpdateTime(null);
		Integer count = goodsMapper.updateByPrimaryKeySelective(goods);
		this.updateGoodsImage(goods.getSimpleImage(), GoodsImageType.SIMPLE.getValue(), goods.getGoodsId());
		this.updateGoodsImage(goods.getDetailsImage(), GoodsImageType.DETAILS.getValue(), goods.getGoodsId());
		this.updateGoodsImage(goods.getWheelImage(), GoodsImageType.WHEEL.getValue(), goods.getGoodsId());
		this.updateGoodsImage(goods.getExtensionImage(), GoodsImageType.EXTENSION.getValue(), goods.getGoodsId());
		this.updateGoodsClasses(goods.getClasses(), goods.getGoodsId());
		return count;
	}

}
