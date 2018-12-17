package com.sifude.lejane.service;

import java.util.Date;

import com.sifude.lejane.entity.SysInformation;
import com.sifude.lejane.entity.mvo.SysInformationDMvo;
import com.sifude.lejane.entity.mvo.SysInformationSMvo;
import com.sifude.tool.util.entity.PageBean;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月23日 下午1:57:57
 * 类说明
 */
public interface IInformationService {

	PageBean<SysInformationSMvo> searchInformationList(String title, String type,
			Date beginTime, Date endTime, Integer status, Integer pageIndex, Integer pageSize);

	SysInformationDMvo detailInformation(Long infoId);

	int checkInformation(String infoIds, Integer status, Long addOpId,
			String addOpName);
	
	int updateInformation(SysInformation information);

	int removeInformation(String infoIds);

	int addInformation(SysInformation information, Long addOpId, String addOpName);

	int restoreInformation(String infoIds);

	int deleteInformation(String infoIds, Long addOpId, String addOpName);

}
