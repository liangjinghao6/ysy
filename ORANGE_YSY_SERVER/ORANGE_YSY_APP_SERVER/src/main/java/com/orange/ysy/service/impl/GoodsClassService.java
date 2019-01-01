package com.orange.ysy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsyGoodsClass;
import com.orange.ysy.entity.YsyGoodsClassExample;
import com.orange.ysy.enumerate.RecordStatus;
import com.orange.ysy.mapper.YsyGoodsClassMapper;
import com.orange.ysy.service.IGoodsClassService;
import com.orange.ysy.util.CreateId;

@Service
public class GoodsClassService implements IGoodsClassService{

	@Autowired
	private YsyGoodsClassMapper goodsclassMapper;
	
	@Override
	public Integer deleteById(String id) {
		YsyGoodsClass goodsclass = new YsyGoodsClass();
		goodsclass.setClassId(id);
		goodsclass.setRecordStatus(RecordStatus.DELETE.getValue());
		return goodsclassMapper.updateByPrimaryKeySelective(goodsclass);
	}


	@Override
	public Integer updateGoodsClass(YsyGoodsClass goodsclass) {
		goodsclass.setRecordStatus(null);
		goodsclass.setCreateTime(null);
		goodsclass.setUpdateTime(null);
		return goodsclassMapper.updateByPrimaryKey(goodsclass);
	}

	@Override
	public Integer addGoodsClass(YsyGoodsClass goodsclass) {
//		if (StringUtils.isEmpty(goodsclass.getGoodsClassName()) || StringUtils.isEmpty(goodsclass.getWx())) {
//			throw new OrangeRunTimeException("参数为空");
//		}
//		
//		YsyGoodsClassExample goodsclassExample = new YsyGoodsClassExample();
//		goodsclassExample.createCriteria().andWxEqualTo(goodsclass.getWx());
//		goodsclassExample.createCriteria().andGoodsClassNameEqualTo(goodsclass.getGoodsClassName());
//		List<YsyGoodsClass> goodsclassCheck = goodsclassMapper.selectByExample(goodsclassExample);
//		if (goodsclassCheck.size() > 0) {
//			throw new OrangeRunTimeException("用户名已经存在");
//		}
		goodsclass.setClassId(CreateId.Uuid());

		goodsclass.setRecordStatus(RecordStatus.NORMAL.getValue());
		return goodsclassMapper.insertSelective(goodsclass);
	}

	@Override
	public PageBean<YsyGoodsClass> findGoodsClass(String q, Integer pageNum, Integer pageSize) {
		PageBean<YsyGoodsClass> pageBean = new PageBean<YsyGoodsClass>();
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		YsyGoodsClassExample goodsclassExample = new YsyGoodsClassExample();
		goodsclassExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue());
//		if(StringUtils.isNotEmpty(q)) {
//			goodsclassExample.createCriteria().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andWxLike("%" + q + "%");
//			goodsclassExample.or().andRecordStatusEqualTo(RecordStatus.NORMAL.getValue()).andGoodsClassNameLike("%" + q + "%");
//		}
		goodsclassExample.setLimit(pageSize);
		goodsclassExample.setOffset((pageNum - 1)*pageSize);
	
		Long total = goodsclassMapper.countByExample(goodsclassExample);
		List<YsyGoodsClass> list = goodsclassMapper.selectByExample(goodsclassExample);
		pageBean.setTotalRecords(total);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public YsyGoodsClass detailGoodsClass(String id) {
		return goodsclassMapper.selectByPrimaryKey(id);
	}

}
