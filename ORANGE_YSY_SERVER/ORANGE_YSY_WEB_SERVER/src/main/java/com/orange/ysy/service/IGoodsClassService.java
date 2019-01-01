package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoodsClass;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface IGoodsClassService {
	
	Integer deleteById(String id);

	Integer updateGoodsClass(YsyGoodsClass user);

	Integer addGoodsClass(YsyGoodsClass user);

	PageBean<YsyGoodsClass> findGoodsClass(String q, Integer page, Integer limit);

	YsyGoodsClass detailGoodsClass(String id);
}
