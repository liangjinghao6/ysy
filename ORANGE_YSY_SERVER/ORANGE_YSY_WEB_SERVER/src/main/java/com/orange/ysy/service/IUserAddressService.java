package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyUserAddress;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface IUserAddressService {
	
	Integer deleteById(String id);

	Integer updateUserAddress(YsyUserAddress user);

	Integer addUserAddress(YsyUserAddress user);

	PageBean<YsyUserAddress> findUserAddress(String q, Integer page, Integer limit);

	YsyUserAddress detailUserAddress(String id);
}
