package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyUserAddress;
import com.orange.ysy.entity.YsyUserAddressExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyUserAddressMapper;
import com.orange.ysy.service.IUserAddressService;
import com.orange.ysy.util.CreateId;

@Service
public class UserAddressService implements IUserAddressService{

	@Autowired
	private YsyUserAddressMapper useraddressMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyUserAddress useraddress = new YsyUserAddress();
		useraddress.setAddressId(id);
		useraddress.setRecordStatus(RecordStatus.DELETE.getValue());
		return useraddressMapper.updateByPrimaryKeySelective(useraddress);
	}

	@Override
	public Integer updateUserAddress(YsyUserAddress useraddress) {
		useraddress.setRecordStatus(null);
		useraddress.setCreateTime(null);
		useraddress.setUpdateTime(null);
		return useraddressMapper.updateByPrimaryKey(useraddress);
	}

	@Override
	public Integer addUserAddress(YsyUserAddress useraddress) {
//		if (StringUtils.isEmpty(useraddress.getUserAddressName()) || StringUtils.isEmpty(useraddress.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyUserAddressExample useraddressExample = new YsyUserAddressExample();
//		useraddressExample.createCriteria().andWxEqualTo(useraddress.getWx());
//		useraddressExample.createCriteria().andUserAddressNameEqualTo(useraddress.getUserAddressName());
//		List<YsyUserAddress> useraddressCheck = useraddressMapper.selectByExample(useraddressExample);
//		if (useraddressCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		useraddress.setRecordStatus(RecordStatus.NORMAL.getValue());
		useraddress.setAddressId(CreateId.Uuid());

		return useraddressMapper.insertSelective(useraddress);
	}

	@Override
	public PageBean<YsyUserAddress> findUserAddress(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyUserAddress> pageBean = new PageBean<YsyUserAddress>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyUserAddressExample useraddressExample = new YsyUserAddressExample();
		useraddressExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			useraddressExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			useraddressExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andUserAddressNameLike("%" + q + "%");
//		}
		useraddressExample.setLimit(pageSize);
		useraddressExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = useraddressMapper.countByExample(useraddressExample);
		List<YsyUserAddress> list = useraddressMapper.selectByExample(useraddressExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyUserAddress detailUserAddress(String id) {
		return useraddressMapper.selectByPrimaryKey(id);
	}

}
