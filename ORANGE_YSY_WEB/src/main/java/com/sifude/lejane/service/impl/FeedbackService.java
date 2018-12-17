package com.sifude.lejane.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sifude.exception.SifudeException;
import com.sifude.lejane.dao.ISysFeedbackDao;
import com.sifude.lejane.entity.SysFeedback;
import com.sifude.lejane.entity.mvo.SysFeedbackDMvo;
import com.sifude.lejane.entity.mvo.SysFeedbackSMvo;
import com.sifude.lejane.exception.SifudeLejaneExceptionEnum;
import com.sifude.lejane.service.IFeedbackService;
import com.sifude.lejane.status.RecordStatus;
import com.sifude.tool.util.entity.PageBean;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月24日 上午10:52:55
 * 类说明
 */
@Service("feedbackService")
public class FeedbackService implements IFeedbackService{
	private static Logger log = LogManager.getLogger(FeedbackService.class);
	
	@Resource(name = "sysFeedbackDao")
	private ISysFeedbackDao sysFeedbackDao;
	
	@Override
	public PageBean<SysFeedbackSMvo> searchFeedbackList(Long ptId,
			Date beginTime, Date endTime, Long addCompId, Integer pageIndex,
			Integer pageSize) {	
		if(null == addCompId){
			throw new SifudeException(SifudeLejaneExceptionEnum.PARAM_IS_NULL, "addCompId");
		}
		
		PageBean<SysFeedbackSMvo> page = new PageBean<SysFeedbackSMvo>();
		
		Integer count = sysFeedbackDao.total(ptId, beginTime, endTime, addCompId);
		
		List<SysFeedbackSMvo> problems = sysFeedbackDao.search(ptId, beginTime, endTime, addCompId, (pageIndex - 1) * pageSize, pageSize);
		
		page.setPageBean(count, pageIndex, pageSize, problems);
		return page;
	}

	@Override
	public SysFeedbackDMvo detailFeedback(Long fbId) {
		SysFeedbackDMvo problem = sysFeedbackDao.detail(fbId);
		if(problem == null) {
			throw new SifudeException(SifudeLejaneExceptionEnum.QUERY_ZERO_ERROR);
		}
		return problem;
	}

	@Override
	public int addFeedback(SysFeedback feedback) {
		feedback.setRecordStatus(RecordStatus.NORMAL.getValue());
		
		try {
			return sysFeedbackDao.save(feedback);
		} catch (Exception e) {
			String message = e.getMessage();
			if(message.contains("Cannot add or update a child row")) {
				if(message.contains("fk_problem_type")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.PROBLEM_TYPE_NOT_EXIST_EXCEPTION, feedback.getPtId() + "");
				}
			}
			log.error(message);
			throw new SifudeException(SifudeLejaneExceptionEnum.INSERT_ERROR);
		}
	}

	@Override
	public int updateFeedback(SysFeedback feedback) {
		int count = 0;
		
		try {
			count = sysFeedbackDao.update(feedback);	
		} catch (Exception e) {
			String message = e.getMessage();
			if(message.contains("Cannot add or update a child row")) {
				if(message.contains("fk_problem_type")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.PROBLEM_TYPE_NOT_EXIST_EXCEPTION, feedback.getPtId() + "");
				}
				if(message.contains("fk_problem_operator")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.PROBLEM_TYPE_NOT_EXIST_EXCEPTION, feedback.getOpId() + "");
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
	public int deleteFeedback(String fbIds) {
		int count = 0;
		for(String fbId : StringUtils.split(fbIds, ",")) {
			SysFeedback feedback = new SysFeedback();
			feedback.setFbId(Long.parseLong(fbId));
			feedback.setRecordStatus(RecordStatus.DELETE.getValue());
			count = count + sysFeedbackDao.update(feedback);
		}
		if(count == 0) {
			throw new SifudeException(SifudeLejaneExceptionEnum.DELETE_ZERO_ERROR);
		}
		return count;
	}

}
