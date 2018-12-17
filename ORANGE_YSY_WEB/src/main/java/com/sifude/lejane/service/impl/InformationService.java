package com.sifude.lejane.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.sifude.exception.SifudeException;
import com.sifude.lejane.dao.ISysInformationDao;
import com.sifude.lejane.entity.SysInformation;
import com.sifude.lejane.entity.mvo.SysInformationDMvo;
import com.sifude.lejane.entity.mvo.SysInformationSMvo;
import com.sifude.lejane.exception.SifudeLejaneExceptionEnum;
import com.sifude.lejane.service.IInformationService;
import com.sifude.lejane.status.InformationCheckStatus;
import com.sifude.lejane.status.RecordStatus;
import com.sifude.tool.util.entity.PageBean;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月23日 下午2:08:41
 * 类说明
 */
@Service("informationService")
public class InformationService implements IInformationService{

	@Resource(name = "sysInformationDao")
	private ISysInformationDao sysInformationDao;
	
	@Override
	public PageBean<SysInformationSMvo> searchInformationList(String title,
			String type, Date beginTime, Date endTime, Integer status, Integer pageIndex,
			Integer pageSize) {
		title = StringUtils.isNotBlank(title) ? "%" + title + "%" : null;
		
		if(status != InformationCheckStatus.NORMAL.getValue() 
				&& status != InformationCheckStatus.PASS.getValue() 
				&& status != InformationCheckStatus.UNPASS.getValue()) {
			throw new SifudeException(SifudeLejaneExceptionEnum.PARAM_ILLEGAL, "status");
		}
		
		PageBean<SysInformationSMvo> page = new PageBean<SysInformationSMvo>();
		
		Integer count = sysInformationDao.total(title, type, beginTime, endTime, status);
		
		List<SysInformationSMvo> informations = sysInformationDao.search(title, type, beginTime, endTime, status, (pageIndex - 1) * pageSize, pageSize);
		
		page.setPageBean(count, pageIndex, pageSize, informations);
		return page;
	}

	@Override
	public SysInformationDMvo detailInformation(Long infoId) {
		SysInformationDMvo information = sysInformationDao.detail(infoId);
		if(information == null) {
			throw new SifudeException(SifudeLejaneExceptionEnum.QUERY_ZERO_ERROR);
		}
		return information;
	}

	@Override
	public int checkInformation(String infoIds, Integer status, Long opId, String opName) {
		int count = 0;
		for(String infoId : StringUtils.split(infoIds, ",")) {
			SysInformation information = new SysInformation();
			information.setInfoId(Long.parseLong(infoId));
			
			if(status == InformationCheckStatus.UNPASS.getValue()) {
				information.setCheckStatus(status);
				information.setRecordStatus(status);
			} else if(status == InformationCheckStatus.PASS.getValue()){
				information.setCheckStatus(status);
			} else {
				throw new SifudeException(SifudeLejaneExceptionEnum.PARAM_ILLEGAL, "status");
			}
			information.setCheckTime(new Date());
			information.setOpId(opId);
			information.setOpName(opName);
			count = count + sysInformationDao.update(information);
		}
		if(count == 0) {
			throw new SifudeException(SifudeLejaneExceptionEnum.UPDATE_ZERO_ERROR);
		}
		return count;
	}
	
	@Override
	public int deleteInformation(String infoIds, Long addOpId, String addOpName) {
		int count = 0;
		for(String infoId : StringUtils.split(infoIds, ",")) {
			SysInformation information = new SysInformation();
			information.setInfoId(Long.parseLong(infoId));			
			information.setRecordStatus(RecordStatus.DELETE.getValue());
			count = count + sysInformationDao.update(information);
		}
		if(count == 0) {
			throw new SifudeException(SifudeLejaneExceptionEnum.UPDATE_ZERO_ERROR);
		}
		return count;
	}
	
	@Override
	public int addInformation(SysInformation information, Long addOpId, String addOpName) {
		information.setCheckStatus(InformationCheckStatus.PASS.getValue());
		information.setCheckTime(new Date());
		information.setOpId(addOpId);
		information.setOpName(addOpName);
		
		int count = 0;
		
		try {
			count = sysInformationDao.save(information);	
		} catch (Exception e) {
			throw new SifudeException(SifudeLejaneExceptionEnum.INSERT_ERROR);
		}
		
		return count;
	}
	
	@Override
	public int updateInformation(SysInformation information) {
		
		information.setCheckTime(null);
		information.setCheckStatus(null);
		information.setOpId(null);
		information.setOpName(null);
		information.setRecordStatus(null);
		
		int count = 0;
		
		try {
			count = sysInformationDao.update(information);	
		} catch (Exception e) {
			throw new SifudeException(SifudeLejaneExceptionEnum.UPDATE_ERROR);
		}
		if(count == 0) {
			throw new SifudeException(SifudeLejaneExceptionEnum.UPDATE_ZERO_ERROR);
		}
		return count;
	}

	@Override
	public int removeInformation(String infoIds) {
		int count = 0;
		for(String infoId : StringUtils.split(infoIds, ",")) {
			count = count + sysInformationDao.delete(Long.parseLong(infoId));
		}
		for(String infoId : StringUtils.split(infoIds, ",")) {
			SysInformation information = new SysInformation();
			information.setInfoId(Long.parseLong(infoId));
			information.setRecordStatus(RecordStatus.REMOVE.getValue());
			count = count + sysInformationDao.update(information);
		}
		
		if(count == 0) {
			throw new SifudeException(SifudeLejaneExceptionEnum.DELETE_ZERO_ERROR);
		}
		return count;
	}
	
	@Override
	public int restoreInformation(String infoIds) {
		int count = 0;
		for(String infoId : StringUtils.split(infoIds, ",")) {
			SysInformation information = new SysInformation();
			SysInformationDMvo informationDMvo = sysInformationDao.detail(Long.parseLong(infoId));
			
			information.setInfoId(informationDMvo.getInfoId());
			if(informationDMvo.getCheckStatus() == InformationCheckStatus.UNPASS.getValue()) {
				information.setCheckStatus(InformationCheckStatus.NORMAL.getValue());
			}
			information.setRecordStatus(RecordStatus.NORMAL.getValue());
			count = count + sysInformationDao.update(information);
		}
		
		if(count == 0) {
			throw new SifudeException(SifudeLejaneExceptionEnum.UPDATE_ZERO_ERROR);
		}
		return count;
	}


	
	
}
