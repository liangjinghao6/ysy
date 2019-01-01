package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyLnkOrderGoods;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface ILnkOrderGoodsService {
	
	Integer deleteById(String id);

	Integer updateLnkOrderGoods(YsyLnkOrderGoods user);

	Integer addLnkOrderGoods(YsyLnkOrderGoods user);

	PageBean<YsyLnkOrderGoods> findLnkOrderGoods(String q, Integer page, Integer limit);

	YsyLnkOrderGoods detailLnkOrderGoods(String id);
}
