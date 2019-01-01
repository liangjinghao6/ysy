package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyOrderBack;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface IOrderBackService {
	
	Integer deleteById(String id);

	Integer updateOrderBack(YsyOrderBack user);

	Integer addOrderBack(YsyOrderBack user);

	PageBean<YsyOrderBack> findOrderBack(String q, Integer page, Integer limit);

	YsyOrderBack detailOrderBack(String id);
}
