package com.sifude.lejane.service;

import java.util.Date;

import com.sifude.lejane.entity.SysFeedback;
import com.sifude.lejane.entity.mvo.SysFeedbackDMvo;
import com.sifude.lejane.entity.mvo.SysFeedbackSMvo;
import com.sifude.tool.util.entity.PageBean;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月24日 上午10:18:29
 * 类说明
 */
public interface IFeedbackService {

	PageBean<SysFeedbackSMvo> searchFeedbackList(Long ptId, Date beginTime,
			Date endTime, Long addCompId, Integer pageIndex, Integer pageSize);

	SysFeedbackDMvo detailFeedback(Long fbId);

	int addFeedback(SysFeedback feedback);

	int updateFeedback(SysFeedback feedback);

	int deleteFeedback(String fbIds);
}
