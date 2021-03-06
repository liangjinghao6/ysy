package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyUser;
import com.orange.ysy.entity.YsyUserExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyUserMapper;
import com.orange.ysy.service.IUserService;
import com.orange.ysy.util.CreateId;

@Service
public class UserService implements IUserService{

	@Autowired
	private YsyUserMapper userMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyUser user = new YsyUser();
		user.setUserId(id);
		user.setRecordStatus(RecordStatus.DELETE.getValue());
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public Integer updateUser(String account, String name, String id, String op) {
		YsyUser user = userMapper.selectByPrimaryKey(id);
		user.setUserName(account);
		user.setNickName(name);
		return userMapper.updateByPrimaryKey(user);
	}


	@Override
	public Integer updateUser(YsyUser user) {
		user.setRecordStatus(null);
		user.setCreateTime(null);
		user.setUpdateTime(null);
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public Integer addUser(YsyUser user) {
		if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getWx())) {
			throw new OrangeRunTimeException("参数为空");
		}
		
		YsyUserExample userExample = new YsyUserExample();
		userExample.createCriteria().andWxEqualTo(user.getWx());
		userExample.createCriteria().andUserNameEqualTo(user.getUserName());
		List<YsyUser> userCheck = userMapper.selectByExample(userExample);
		if (userCheck.size() > 0) {
			throw new OrangeRunTimeException("用户名已经存在");
		}
		user.setUserId(CreateId.Uuid());

		return userMapper.insertSelective(user);
	}

	@Override
	public PageBean<YsyUser> findUser(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyUser> pageBean = new PageBean<YsyUser>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyUserExample userExample = new YsyUserExample();
		userExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
		if(StringUtils.isNotEmpty(q)) {
			userExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
			userExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andUserNameLike("%" + q + "%");
		}
		userExample.setLimit(pageSize);
		userExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = userMapper.countByExample(userExample);
		List<YsyUser> list = userMapper.selectByExample(userExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyUser detailUser(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
