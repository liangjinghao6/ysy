package com.orange.ysy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoods;
import com.orange.ysy.entity.YsyGoodsBrand;
import com.orange.ysy.entity.YsyGoodsCategory;
import com.orange.ysy.entity.YsyGoodsClass;
import com.orange.ysy.entity.YsyGoodsExample;
import com.orange.ysy.entity.YsyGoodsFeature;
import com.orange.ysy.entity.YsySysFile;
import com.orange.ysy.entity.mvo.YsyGoodsFeatureMvo;
import com.orange.ysy.entity.mvo.YsyGoodsMvo;
import com.orange.ysy.enumerate.GoodsImageType;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.mapper.AYsyGoodsMapper;
import com.orange.ysy.mapper.YsyGoodsBrandMapper;
import com.orange.ysy.mapper.YsyGoodsCategoryMapper;
import com.orange.ysy.mapper.YsyLnkGoodsClassMapper;
import com.orange.ysy.mapper.YsyLnkGoodsImageMapper;
import com.orange.ysy.service.IGoodsService;
import com.orange.ysy.util.ClassUtil;

@Service
public class GoodsService implements IGoodsService {

	@Autowired
	private AYsyGoodsMapper goodsMapper;
	@Autowired
	private YsyLnkGoodsImageMapper lnkGoodsImageMapper;
	@Autowired
	private YsyLnkGoodsClassMapper lnkGoodsClassMapper;
	@Autowired
	private YsyGoodsBrandMapper goodsBrandMapper;
	@Autowired
	private YsyGoodsCategoryMapper goodsCategoryMapper;

	@Override
	public PageBean<YsyGoods> findGoods(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyGoods> pageBean = new PageBean<YsyGoods>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyGoodsExample goodsExample = new YsyGoodsExample();
		goodsExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
		// if(StringUtils.isNotEmpty(q)) {
		// goodsExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%"
		// + q + "%");
		// goodsExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andGoodsNameLike("%"
		// + q + "%");
		// }
		goodsExample.setLimit(pageSize);
		goodsExample.setOffset((pageNum - 1) * pageSize);

		Long total = goodsMapper.countByExample(goodsExample);
		List<YsyGoods> list = goodsMapper.selectByExample(goodsExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyGoodsMvo detailGoods(String id) throws Exception {
		YsyGoods goods = goodsMapper.selectByPrimaryKey(id);
		YsyGoodsMvo goodsMvo = new YsyGoodsMvo();
		ClassUtil.fatherToChild(goods, goodsMvo);
		goodsMvo.setFeatures(getFeatureByGoodsId(goodsMvo.getGoodsId()));
		goodsMvo.setBrand(getBrandByGoodsId(goodsMvo.getBrandId()));
		goodsMvo.setCategory(getCategoryByGoodsId(goodsMvo.getCategoryId()));
		goodsMvo.setSimpleImage(getImagesByGoodsId(goodsMvo.getGoodsId(), GoodsImageType.SIMPLE.getValue()));
		goodsMvo.setDetailsImage(getImagesByGoodsId(goodsMvo.getGoodsId(), GoodsImageType.DETAILS.getValue()));
		goodsMvo.setWheelImage(getImagesByGoodsId(goodsMvo.getGoodsId(), GoodsImageType.WHEEL.getValue()));
		goodsMvo.setExtensionImage(getImagesByGoodsId(goodsMvo.getGoodsId(), GoodsImageType.EXTENSION.getValue()));
		return goodsMvo;
	}

	private YsyGoodsCategory getCategoryByGoodsId(String categoryId) {
		return goodsCategoryMapper.selectByPrimaryKey(categoryId);
	}

	private YsyGoodsBrand getBrandByGoodsId(String brandId) {
		return goodsBrandMapper.selectByPrimaryKey(brandId);
	}

	private List<YsySysFile> getImagesByGoodsId(String goodsId, Short type) {
		return goodsMapper.getImagesByGoodsId(goodsId, type);
	}

	private List<YsyGoodsFeatureMvo> getFeatureByGoodsId(String goodsId) throws Exception {
		List<YsyGoodsFeatureMvo> features = goodsMapper.selectFeatueIdByGoodsId(goodsId);
		for (YsyGoodsFeatureMvo feature : features) {
			feature.setClasses(getClassByGoodsAndFeature(goodsId, feature.getFeatureId()));
		}
		return features;
	}

	private List<YsyGoodsClass> getClassByGoodsAndFeature(String goodsId, String featureId) {
		return goodsMapper.selectClassByGoodsAndFeature(goodsId, featureId);
	}

}
