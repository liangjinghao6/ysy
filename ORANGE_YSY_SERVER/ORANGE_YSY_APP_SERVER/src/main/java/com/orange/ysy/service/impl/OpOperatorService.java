package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyOpOperator;
import com.orange.ysy.entity.YsyOpOperatorExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyOpOperatorMapper;
import com.orange.ysy.service.IOpOperatorService;
import com.orange.ysy.util.CreateId;

@Service
public class OpOperatorService implements IOpOperatorService{

	@Autowired
	private YsyOpOperatorMapper opoperatorMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyOpOperator opoperator = new YsyOpOperator();
		opoperator.setOperatorId(id);
		opoperator.setRecordStatus(RecordStatus.DELETE.getValue());
		return opoperatorMapper.updateByPrimaryKeySelective(opoperator);
	}

	@Override
	public Integer updateOpOperator(YsyOpOperator opoperator) {
		opoperator.setRecordStatus(null);
		opoperator.setCreateTime(null);
		opoperator.setUpdateTime(null);
		return opoperatorMapper.updateByPrimaryKey(opoperator);
	}

	@Override
	public Integer addOpOperator(YsyOpOperator opoperator) {
//		if (StringUtils.isEmpty(opoperator.getOpOperatorName()) || StringUtils.isEmpty(opoperator.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyOpOperatorExample opoperatorExample = new YsyOpOperatorExample();
//		opoperatorExample.createCriteria().andWxEqualTo(opoperator.getWx());
//		opoperatorExample.createCriteria().andOpOperatorNameEqualTo(opoperator.getOpOperatorName());
//		List<YsyOpOperator> opoperatorCheck = opoperatorMapper.selectByExample(opoperatorExample);
//		if (opoperatorCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		opoperator.setOperatorId(CreateId.Uuid());

		opoperator.setRecordStatus(RecordStatus.NORMAL.getValue());
		return opoperatorMapper.insertSelective(opoperator);
	}

	@Override
	public PageBean<YsyOpOperator> findOpOperator(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyOpOperator> pageBean = new PageBean<YsyOpOperator>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyOpOperatorExample opoperatorExample = new YsyOpOperatorExample();
		opoperatorExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			opoperatorExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			opoperatorExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andOpOperatorNameLike("%" + q + "%");
//		}
		opoperatorExample.setLimit(pageSize);
		opoperatorExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = opoperatorMapper.countByExample(opoperatorExample);
		List<YsyOpOperator> list = opoperatorMapper.selectByExample(opoperatorExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyOpOperator detailOpOperator(String id) {
		return opoperatorMapper.selectByPrimaryKey(id);
	}

}
