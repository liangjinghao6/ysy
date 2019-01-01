package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyLnkBackGoods;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface ILnkBackGoodsService {
	
	Integer deleteById(String id);

	Integer updateLnkBackGoods(YsyLnkBackGoods user);

	Integer addLnkBackGoods(YsyLnkBackGoods user);

	PageBean<YsyLnkBackGoods> findLnkBackGoods(String q, Integer page, Integer limit);

	YsyLnkBackGoods detailLnkBackGoods(String id);
}
