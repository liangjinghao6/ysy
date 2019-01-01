package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoodsBrand;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface IGoodsBrandService {
	
	Integer deleteById(String id);

	Integer updateGoodsBrand(YsyGoodsBrand user);

	Integer addGoodsBrand(YsyGoodsBrand user);

	PageBean<YsyGoodsBrand> findGoodsBrand(String q, Integer page, Integer limit);

	YsyGoodsBrand detailGoodsBrand(String id);
}
