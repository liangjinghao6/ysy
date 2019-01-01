package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoodsCategory;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface IGoodsCategoryService {
	
	Integer deleteById(String id);

	Integer updateGoodsCategory(YsyGoodsCategory user);

	Integer addGoodsCategory(YsyGoodsCategory user);

	PageBean<YsyGoodsCategory> findGoodsCategory(String q, Integer page, Integer limit);

	YsyGoodsCategory detailGoodsCategory(String id);
}
