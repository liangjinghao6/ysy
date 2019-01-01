package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyOpOperator;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface IOpOperatorService {
	
	Integer deleteById(String id);

	Integer updateOpOperator(YsyOpOperator user);

	Integer addOpOperator(YsyOpOperator user);

	PageBean<YsyOpOperator> findOpOperator(String q, Integer page, Integer limit);

	YsyOpOperator detailOpOperator(String id);
}
