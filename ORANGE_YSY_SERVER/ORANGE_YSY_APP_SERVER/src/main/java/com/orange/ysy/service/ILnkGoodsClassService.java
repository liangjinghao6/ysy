package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyLnkGoodsClass;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface ILnkGoodsClassService {
	
	Integer deleteById(String id);

	Integer updateLnkGoodsClass(YsyLnkGoodsClass user);

	Integer addLnkGoodsClass(YsyLnkGoodsClass user);

	PageBean<YsyLnkGoodsClass> findLnkGoodsClass(String q, Integer page, Integer limit);

	YsyLnkGoodsClass detailLnkGoodsClass(String id);
}
