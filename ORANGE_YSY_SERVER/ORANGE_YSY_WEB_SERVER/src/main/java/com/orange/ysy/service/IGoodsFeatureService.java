package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoodsFeature;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface IGoodsFeatureService {
	
	Integer deleteById(String id);

	Integer updateGoodsFeature(YsyGoodsFeature user);

	Integer addGoodsFeature(YsyGoodsFeature user);

	PageBean<YsyGoodsFeature> findGoodsFeature(String q, Integer page, Integer limit);

	YsyGoodsFeature detailGoodsFeature(String id);
}
