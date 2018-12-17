package com.sifude.lejane.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sifude.exception.SifudeException;
import com.sifude.lejane.dao.ISysProblemDao;
import com.sifude.lejane.dao.ISysProblemTypeDao;
import com.sifude.lejane.entity.SysProblem;
import com.sifude.lejane.entity.SysProblemType;
import com.sifude.lejane.entity.mvo.SysProblemDMvo;
import com.sifude.lejane.entity.mvo.SysProblemLMvo;
import com.sifude.lejane.entity.mvo.SysProblemTypeLMvo;
import com.sifude.lejane.exception.SifudeLejaneExceptionEnum;
import com.sifude.lejane.service.IProblemService;
import com.sifude.lejane.status.RecordStatus;
import com.sifude.tool.util.entity.PageBean;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月22日 下午6:02:30
 * 类说明
 */
@Service("problemService")
public class ProblemService implements IProblemService{
	private static Logger log = LogManager.getLogger(ProblemService.class);
	
	@Resource(name = "sysProblemDao")
	private ISysProblemDao sysProblemDao;
	
	@Resource(name = "sysProblemTypeDao")
	private ISysProblemTypeDao sysProblemTypeDao;
	
	@Override
	public PageBean<SysProblemLMvo> searchProblemList(String title, Long ptId,
			Date beginTime, Date endTime, Long addCompId,
			Integer pageIndex, Integer pageSize) {
		title = StringUtils.isNotBlank(title) ? "%" + title + "%" : null;
		
		if(null == addCompId){
			throw new SifudeException(SifudeLejaneExceptionEnum.PARAM_IS_NULL, "addCompId");
		}
		
		PageBean<SysProblemLMvo> page = new PageBean<SysProblemLMvo>();
		
		Integer count = sysProblemDao.total(title, ptId, beginTime, endTime, addCompId);
		
		List<SysProblemLMvo> problems = sysProblemDao.search(title, ptId, beginTime, endTime, addCompId, (pageIndex - 1) * pageSize, pageSize);
		
		page.setPageBean(count, pageIndex, pageSize, problems);
		return page;
	}

	@Override
	public SysProblemDMvo detailProblem(Long proId) {
		SysProblemDMvo problem = sysProblemDao.detail(proId);
		if(problem == null) {
			throw new SifudeException(SifudeLejaneExceptionEnum.QUERY_ZERO_ERROR);
		}
		return problem;
	}

	@Override
	public int addProblem(SysProblem problem) {
		problem.setRecordStatus(RecordStatus.NORMAL.getValue());
	
		try {
			return sysProblemDao.save(problem);
		} catch (Exception e) {
			String message = e.getMessage();
			if(message.contains("Duplicate entry")) {
				if (message.contains("uk_problem_title")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.PROBLEM_EXIST_EXCEPTION, problem.getTitle());
				}
			} if(message.contains("Cannot add or update a child row")) {
				if(message.contains("fk_problem_type")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.PROBLEM_TYPE_NOT_EXIST_EXCEPTION, problem.getPtId() + "");
				}
			}
			log.error(message);
			throw new SifudeException(SifudeLejaneExceptionEnum.INSERT_ERROR);
		}
	}

	@Override
	public int updateProblem(SysProblem problem) {
		int count = 0;
		
		try {
			count = sysProblemDao.update(problem);	
		} catch (Exception e) {
			String message = e.getMessage();
			if(message.contains("Duplicate entry")) {
				if (message.contains("uk_problem_title")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.PROBLEM_EXIST_EXCEPTION, problem.getTitle());
				}
			} if(message.contains("Cannot add or update a child row")) {
				if(message.contains("fk_problem_type")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.PROBLEM_TYPE_NOT_EXIST_EXCEPTION, problem.getPtId() + "");
				}
			}
			log.error(message);
			throw new SifudeException(SifudeLejaneExceptionEnum.UPDATE_ERROR);
		}
		if(count == 0) {
			throw new SifudeException(SifudeLejaneExceptionEnum.UPDATE_ZERO_ERROR);
		}
		return count;
	}

	@Override
	public int deleteProblem(String proIds) {
		int count = 0;
		for(String proId : StringUtils.split(proIds, ",")) {
			SysProblem problem = new SysProblem();
			problem.setProId(Long.parseLong(proId));
			problem.setRecordStatus(RecordStatus.DELETE.getValue());
			problem.setRecordDelete(new Random().nextInt(100000));
			count = count + sysProblemDao.update(problem);
		}
		if(count == 0) {
			throw new SifudeException(SifudeLejaneExceptionEnum.DELETE_ZERO_ERROR);
		}
		return count;
	}
	
	
	@Override
	public int existProblem(String name) {
		int count = sysProblemDao.exist(name);
		if(count > 0){
			throw new SifudeException(SifudeLejaneExceptionEnum.PROBLEM_EXIST_EXCEPTION, name);
		}
		return count;
	}

	@Override
	public List<SysProblemTypeLMvo> listProblemType(String name, Integer size) {
		name = StringUtils.isNotBlank(name) ? "%" + name + "%" : null;
		
		return sysProblemTypeDao.list(name, size);
	}

	@Override
	public int addProblemType(SysProblemType problem) {
		return sysProblemTypeDao.save(problem);
	}

}
