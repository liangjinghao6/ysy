package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoods;
import com.orange.ysy.entity.mvo.YsyGoodsMvo;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface IGoodsService {
	
	Integer deleteById(String id);

	Integer updateGoods(YsyGoodsMvo user);

	Integer addGoods(YsyGoodsMvo user);

	PageBean<YsyGoods> findGoods(String q, Integer page, Integer limit);

	YsyGoodsMvo detailGoods(String id) throws Exception;
}
