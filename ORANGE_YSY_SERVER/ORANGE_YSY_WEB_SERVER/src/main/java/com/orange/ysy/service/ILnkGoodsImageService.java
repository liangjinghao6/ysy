package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyLnkGoodsImage;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface ILnkGoodsImageService {
	
	Integer deleteById(String id);

	Integer updateLnkGoodsImage(YsyLnkGoodsImage user);

	Integer addLnkGoodsImage(YsyLnkGoodsImage user);

	PageBean<YsyLnkGoodsImage> findLnkGoodsImage(String q, Integer page, Integer limit);

	YsyLnkGoodsImage detailLnkGoodsImage(String id);
}
