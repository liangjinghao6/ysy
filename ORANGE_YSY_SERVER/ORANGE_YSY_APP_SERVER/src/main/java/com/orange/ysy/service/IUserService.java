package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyUser;

public interface IUserService {

	Integer deleteById(String id);

	Integer updateUser(YsyUser user);

	Integer addUser(YsyUser user);

	PageBean<YsyUser> findUser(String q, Integer page, Integer limit);

	YsyUser detailUser(String id);

	Integer updateUser(String account, String name, String id, String op);

}
