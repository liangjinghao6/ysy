package com.sifude.lejane.service;

import java.util.Date;
import java.util.List;

import com.sifude.lejane.entity.SysProblem;
import com.sifude.lejane.entity.SysProblemType;
import com.sifude.lejane.entity.mvo.SysProblemDMvo;
import com.sifude.lejane.entity.mvo.SysProblemLMvo;
import com.sifude.lejane.entity.mvo.SysProblemTypeLMvo;
import com.sifude.tool.util.entity.PageBean;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月22日 下午4:07:45
 * 类说明
 */
public interface IProblemService {

	PageBean<SysProblemLMvo> searchProblemList(String title, Long ptId,
			Date beginTime, Date endTime, Long addCompId,
			Integer pageIndex, Integer pageSize);

	SysProblemDMvo detailProblem(Long proId);

	int addProblem(SysProblem problem);

	int updateProblem(SysProblem problem);

	int deleteProblem(String proIds);

	int existProblem(String name);

	List<SysProblemTypeLMvo> listProblemType(String name, Integer size);

	int addProblemType(SysProblemType problem);

}
