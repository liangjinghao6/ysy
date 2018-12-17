package com.sifude.lejane.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sifude.exception.SifudeException;
import com.sifude.lejane.dao.IUsrArchivesDao;
import com.sifude.lejane.dao.IUsrErrorDataDao;
import com.sifude.lejane.dao.IUsrFamilyDao;
import com.sifude.lejane.dao.IUsrHabbitDao;
import com.sifude.lejane.dao.IUsrMemberDao;
import com.sifude.lejane.entity.UsrArchives;
import com.sifude.lejane.entity.UsrErrorData;
import com.sifude.lejane.entity.UsrFamily;
import com.sifude.lejane.entity.UsrHabbit;
import com.sifude.lejane.entity.UsrMember;
import com.sifude.lejane.entity.excel.ArchiveErrorExcel;
import com.sifude.lejane.entity.excel.ArchiveExportExcel;
import com.sifude.lejane.entity.excel.ArchiveImportExcel;
import com.sifude.lejane.entity.mvo.UsrArchivesDMvo;
import com.sifude.lejane.entity.mvo.UsrArchivesUMvo;
import com.sifude.lejane.entity.mvo.UsrArchivesSMvo;
import com.sifude.lejane.entity.mvo.UsrErrorDataLMvo;
import com.sifude.lejane.entity.mvo.UsrFamilyLMvo;
import com.sifude.lejane.entity.mvo.UsrMemberDMvo;
import com.sifude.lejane.entity.mvo.UsrMemberFMvo;
import com.sifude.lejane.entity.mvo.UsrMemberSMvo;
import com.sifude.lejane.exception.SifudeLejaneExceptionEnum;
import com.sifude.lejane.service.IMemberService;
import com.sifude.lejane.status.ArchivesDrinkStatus;
import com.sifude.lejane.status.ArchivesEatStatus;
import com.sifude.lejane.status.ArchivesHealthStatus;
import com.sifude.lejane.status.ArchivesMidnightStatus;
import com.sifude.lejane.status.ArchivesMoveStatus;
import com.sifude.lejane.status.ArchivesNapStatus;
import com.sifude.lejane.status.ArchivesSmokeStatus;
import com.sifude.lejane.status.DataReadStatus;
import com.sifude.lejane.status.RecordStatus;
import com.sifude.lejane.util.ExcelUtil;
import com.sifude.lejane.util.HuanXinUtil;
import com.sifude.lejane.util.SystemUtil;
import com.sifude.tool.util.FileUtil;
import com.sifude.tool.util.JsonUtil;
import com.sifude.tool.util.MD5Util;
import com.sifude.tool.util.entity.PageBean;


/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午4:55:54
 * 类说明
 */
@Service("memberService")
public class MemberService implements IMemberService{
	private static Logger log = LogManager.getLogger(MemberService.class);
	
	@Resource(name = "usrMemberDao")
	private IUsrMemberDao usrMemberDao;
	
	@Resource(name = "usrArchivesDao")
	private IUsrArchivesDao usrArchivesDao;
	
	@Resource(name = "usrHabbitDao")
	private IUsrHabbitDao usrHabbitDao;
	
	@Resource(name = "usrFamilyDao")
	private IUsrFamilyDao usrFamilyDao;
	
	@Resource(name = "usrErrorDataDao")
	private IUsrErrorDataDao usrErrorDataDao;
	
	@Resource(name = "batchUpdateMemberWriter")
	private MyBatisBatchItemWriter<UsrMember> batchUpdateMemberWriter;

	@Resource(name = "batchSaveArchivesWriter")
	private MyBatisBatchItemWriter<UsrArchives> batchSaveArchivesWriter;

	@Resource(name = "batchSaveHabbitWriter")
	private MyBatisBatchItemWriter<UsrHabbit> batchSaveHabbitWriter;
	
	@Resource(name = "huanXinUtil")
	private HuanXinUtil huanXinUtil;
	
	@Resource(name = "systemUtil")
	private SystemUtil systemUtil;
	
	@Override
	public PageBean<UsrMemberSMvo> searchMember(String name, String phone,
			String account, Integer archiveStatus, Date beginTime, Date endTime,
			Integer opStatus, String compName, String opName,
			Integer pageIndex, Integer pageSize, Long addOpId,
			Long addRoleLevel, Long addCompId) {
		name = StringUtils.isEmpty(name) ? null : "%" + name + "%";
		account = StringUtils.isEmpty(account) ? null : "%" + account + "%";
		phone = StringUtils.isEmpty(phone) ? null : "%" + phone + "%";
		opName = StringUtils.isEmpty(opName) ? null : "%" + opName + "%";
		compName = StringUtils.isNotBlank(compName) ? "%" + compName + "%" : null;
		
		if(null == addRoleLevel){
			throw new SifudeException(SifudeLejaneExceptionEnum.PARAM_IS_NULL, "addRoleLevel");
		}
		
		PageBean<UsrMemberSMvo> page = new PageBean<UsrMemberSMvo>();
		Integer count = usrMemberDao.totalMember(name, phone, account, archiveStatus, beginTime, endTime,
				opStatus, compName, opName, addOpId, addRoleLevel, addCompId);
		List<UsrMemberSMvo> members = usrMemberDao.searchMember(name, phone, account, archiveStatus, beginTime, endTime,
				opStatus, compName, opName, (pageIndex-1)*pageSize, pageSize, addOpId, addRoleLevel, addCompId);
		page.setPageBean(count, pageIndex, pageSize, members);
		
		return page;
	}

	@Override
	public UsrMemberDMvo detailMember(Long memberId) {
		UsrMemberDMvo dMvo = usrMemberDao.detail(memberId);
		if(dMvo == null) {
			throw new SifudeException(SifudeLejaneExceptionEnum.QUERY_ZERO_ERROR);
		}
		return dMvo;
	}

	@Override
	public int addMember(UsrMember member) {
		member.setPassword(MD5Util.GetMD5Code(member.getPassword(), null, false));
		member.setRecordStatus(RecordStatus.NORMAL.getValue());
		int count = 0;
		try {
			count = usrMemberDao.save(member);
		} catch (Exception e) {
			String message = e.getMessage();
			if(message.contains("Duplicate entry")) {
				if(message.contains("uk_member_account")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.USER_EXIST_EXCEPTION, member.getAccount());
				} else if (message.contains("uk_member_phone")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.PHONE_EXIST_EXCEPTION, member.getPhone());
				}
			} if(message.contains("Cannot add or update a child row")) {
				if(message.contains("fk_member_store")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.STORE_NOT_EXIST_EXCEPTION, member.getCompId() + "");
				}
				if(message.contains("fk_member_operator")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.SERVER_NOT_EXIST_EXCEPTION, member.getCompId() + "");
				}
			}
			log.error(message);
			throw new SifudeException(SifudeLejaneExceptionEnum.INSERT_ERROR);
		}
		huanXinUtil.registChatUser(member.getAccount(), member.getPassword(), member.getName());
		return count;
	}

	@Override
	public int updateMember(UsrMember member) {
		if (!StringUtils.isEmpty(member.getPassword())) {
			member.setPassword(MD5Util.GetMD5Code(member.getPassword(), null, false));
		}
		int count = 0;
		try {
			count = usrMemberDao.update(member);
		} catch (Exception e) {
			String message = e.getMessage();
			if(message.contains("Duplicate entry")) {
				if(message.contains("uk_member_account")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.USER_EXIST_EXCEPTION, member.getAccount());
				} else if (message.contains("uk_member_phone")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.PHONE_EXIST_EXCEPTION, member.getPhone());
				} 
			} if(message.contains("Cannot add or update a child row")) {
				if(message.contains("fk_member_store")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.STORE_NOT_EXIST_EXCEPTION, member.getCompId() + "");
				}
				if(message.contains("fk_member_operator")) {
					throw new SifudeException(SifudeLejaneExceptionEnum.SERVER_NOT_EXIST_EXCEPTION, member.getCompId() + "");
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
	public UsrArchivesUMvo uploadArchive(MultipartFile file, Long addCompId) {
		//TODO step1:记录文件上传记录
		
		//step2:上传文件
		log.trace(systemUtil.getArchiveUploadPath());
		String path = FileUtil.fileUpload(file, systemUtil.getArchiveUploadPath());
		if(path == null) {
			throw new SifudeException(SifudeLejaneExceptionEnum.OTHER_ERROR);
		}
		//TODO step3:更新上传记录
		
		//step4:将上传的excel转化为bean
		log.trace(path);
		List<ArchiveImportExcel> archiveExcels = ExcelUtil.importExcel(path, ArchiveImportExcel.class);
		log.trace("读取的excel" + JsonUtil.toJson(archiveExcels));
		//step5:过滤不符合要求的电话，获得电话和membId的对应关系
		Map<String, Long> phoneAndIdParam = new HashMap<String, Long>();
		List<UsrMemberFMvo> memberFMvos = usrMemberDao.filterPhone(archiveExcels, addCompId);
		for(UsrMemberFMvo memberFMvo : memberFMvos) {
			phoneAndIdParam.put(memberFMvo.getPhone(), memberFMvo.getMembId());
		}
		log.trace("合法的phone：" + phoneAndIdParam);
		//step6:将excelbean转换问要更新的bean,记录处理失败的记录
		List<UsrMember> members = new ArrayList<UsrMember>();
		List<UsrArchives> archives = new ArrayList<UsrArchives>();
		List<UsrHabbit> habbits = new ArrayList<UsrHabbit>();
		List<ArchiveErrorExcel> errors = new ArrayList<ArchiveErrorExcel>();
		for(ArchiveImportExcel archiveExcel : archiveExcels) {
			Long membId = phoneAndIdParam.get(archiveExcel.getPhone());
			if(membId == null) {
				addErrorMessage(archiveExcel, "电话号码错误", errors);
				continue;
			}
			UsrMember member = getMemberFromArchive(archiveExcel, membId);
			UsrArchives archive = null;
			UsrHabbit habbit = null;
			try {
				archive = getArchivesFromArchive(archiveExcel, membId);
				habbit = getHabbitFromArchive(archiveExcel, membId);
			} catch (SifudeException e) {
				addErrorMessage(archiveExcel, e.getMessage(), errors);
				continue;
			}
			members.add(member);
			habbits.add(habbit);
			archives.add(archive);
		}
		//step7:批量更新数据库

		batchSaveArchivesWriter.write(archives);
		batchSaveHabbitWriter.write(habbits);
		batchUpdateMemberWriter.write(members);

		log.trace(JsonUtil.toJson(archives));
		log.trace(JsonUtil.toJson(habbits));
		log.trace(JsonUtil.toJson(members));
		log.trace(JsonUtil.toJson(errors));
		//step8:将失败的数据写到服务器
		UsrArchivesUMvo archiveUMvo = new UsrArchivesUMvo();
		archiveUMvo.setFail(errors.size());
		String fileName = null;
		if(errors.size() > 0) {
			fileName = StringUtils.substringAfterLast(path, "/");
			try {
				ExcelUtil.exportExcel(systemUtil.getArchiveErrorPath() + fileName, ArchiveErrorExcel.class, errors);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new SifudeException(SifudeLejaneExceptionEnum.OTHER_ERROR);
			}
		}
		//step9:返回总共条数成功条数和失败文件的名字
		archiveUMvo.setTotal(archiveExcels.size());
		archiveUMvo.setSuccess(members.size());
		archiveUMvo.setErrorName(fileName);
		//step10:释放内存
		archiveExcels.clear();
		members.clear();
		archives.clear();
		habbits.clear();
		errors.clear();
		
		return archiveUMvo;
		
	}
	
	private UsrHabbit getHabbitFromArchive(ArchiveImportExcel archiveExcel, Long membId) {
		UsrHabbit habbit = new UsrHabbit();
		habbit.setCharacteristic(archiveExcel.getCharacteristic());
		habbit.setCheckTime(new Date());
		if(StringUtils.isEmpty(archiveExcel.getIsDrink())) {
		} else if(StringUtils.equals(archiveExcel.getIsDrink(), ArchivesDrinkStatus.YES.getName())) {
			habbit.setIsDrink(ArchivesDrinkStatus.YES.getValue());	
		} else if(StringUtils.equals(archiveExcel.getIsDrink(), ArchivesDrinkStatus.NO.getName())) {
			habbit.setIsDrink(ArchivesDrinkStatus.NO.getValue());	
		} else {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_IMPORT_FORMAT_EXCEPATION, "是否喝酒");
		}
		if(StringUtils.isEmpty(archiveExcel.getIsEatWell())) {
		} else if(StringUtils.equals(archiveExcel.getIsEatWell(), ArchivesEatStatus.YES.getName())) {
			habbit.setIsEatWell(ArchivesEatStatus.YES.getValue());	
		} else if(StringUtils.equals(archiveExcel.getIsEatWell(), ArchivesEatStatus.NO.getName())) {
			habbit.setIsEatWell(ArchivesEatStatus.NO.getValue());	
		} else {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_IMPORT_FORMAT_EXCEPATION, "饮食规律");
		}
		if(StringUtils.isEmpty(archiveExcel.getIsMidnightOrNap())) {
			habbit.setIsMidnight(ArchivesMidnightStatus.NO.getValue());
			habbit.setIsNap(ArchivesNapStatus.NO.getValue());
		} else if(StringUtils.equals(archiveExcel.getIsMidnightOrNap(), "熬夜")) {
			habbit.setIsMidnight(ArchivesMidnightStatus.YES.getValue());
			habbit.setIsNap(ArchivesNapStatus.NO.getValue());
		} else if(StringUtils.equals(archiveExcel.getIsMidnightOrNap(), "午睡")) {
			habbit.setIsMidnight(ArchivesMidnightStatus.NO.getValue());
			habbit.setIsNap(ArchivesNapStatus.YES.getValue());
		} else if(StringUtils.equals(archiveExcel.getIsMidnightOrNap(), "熬夜，午睡")) {
			habbit.setIsMidnight(ArchivesMidnightStatus.YES.getValue());
			habbit.setIsNap(ArchivesNapStatus.YES.getValue());
		} else {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_IMPORT_FORMAT_EXCEPATION, "是否熬夜或午睡");
		}
		if(StringUtils.isEmpty(archiveExcel.getIsMove())) {
		} else if(StringUtils.equals(archiveExcel.getIsMove(), ArchivesMoveStatus.EVERY_DAY.getName())) {
			habbit.setIsMove(ArchivesMoveStatus.EVERY_DAY.getValue());
		} else if(StringUtils.equals(archiveExcel.getIsMove(), ArchivesMoveStatus.OFTEN.getName())) {
			habbit.setIsMove(ArchivesMoveStatus.OFTEN.getValue());
		} else if(StringUtils.equals(archiveExcel.getIsMove(), ArchivesMoveStatus.OCCASIONALLY.getName())) {
			habbit.setIsMove(ArchivesMoveStatus.OCCASIONALLY.getValue());
		} else if(StringUtils.equals(archiveExcel.getIsMove(), ArchivesMoveStatus.RARELY.getName())) {
			habbit.setIsMove(ArchivesMoveStatus.RARELY.getValue());
		} else {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_IMPORT_FORMAT_EXCEPATION, "运动情况");
		}
		if(StringUtils.isEmpty(archiveExcel.getIsSmoke())) {
		} else if(StringUtils.equals(archiveExcel.getIsSmoke(), ArchivesSmokeStatus.YES.getName())) {
			habbit.setIsSmoke(ArchivesSmokeStatus.YES.getValue());	
		} else if(StringUtils.equals(archiveExcel.getIsSmoke(), ArchivesSmokeStatus.NO.getName())) {
			habbit.setIsSmoke(ArchivesSmokeStatus.NO.getValue());	
		} else {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_IMPORT_FORMAT_EXCEPATION, "是否喝酒");
		}
		habbit.setMembId(membId);
		habbit.setSleepHabbit(archiveExcel.getSleepHabbit());
		return habbit;
	}

	private UsrArchives getArchivesFromArchive(ArchiveImportExcel archiveExcel, Long membId) {
		UsrArchives archive = new UsrArchives();
		archive.setBooldFat(archiveExcel.getBooldFat());
		archive.setBooldSugar(archiveExcel.getBooldSugar());
		archive.setCheckTime(new Date());
		if(archiveExcel.getDescription().length() > 200) {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_IMPORT_FORMAT_EXCEPATION, "描述");
		}
		archive.setDescription(archiveExcel.getDescription());
		archive.setDigestion(archiveExcel.getDigestion());
		if(StringUtils.equals(archiveExcel.getHealthStatus(), ArchivesHealthStatus.EXCELLENT.getName())) {
			archive.setHealthStatus(ArchivesHealthStatus.EXCELLENT.getValue());
		} else if(StringUtils.equals(archiveExcel.getHealthStatus(), ArchivesHealthStatus.GOOD.getName())) {
			archive.setHealthStatus(ArchivesHealthStatus.GOOD.getValue());
		} else if(StringUtils.equals(archiveExcel.getHealthStatus(), ArchivesHealthStatus.GENERAL.getName())) {
			archive.setHealthStatus(ArchivesHealthStatus.GENERAL.getValue());
		} else if(StringUtils.equals(archiveExcel.getHealthStatus(), ArchivesHealthStatus.BAD.getName())) {
			archive.setHealthStatus(ArchivesHealthStatus.BAD.getValue());
		} else {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_IMPORT_FORMAT_EXCEPATION, "健康状况");
		}
		try {
			archive.setHighPressure(Integer.parseInt(archiveExcel.getHighPressure()));
		} catch (Exception e) {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_IMPORT_FORMAT_EXCEPATION, "高压");
		}
		try {
			archive.setLowPressure(Integer.parseInt(archiveExcel.getLowPressure()));
		} catch (Exception e) {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_IMPORT_FORMAT_EXCEPATION, "低压");
		}
		archive.setLimbsTemp(archiveExcel.getLimbsTemp());
		archive.setMembId(membId);
		archive.setSleep(archiveExcel.getSleep());
		archive.setTongue(archiveExcel.getTongue());
		archive.setUrine(archiveExcel.getUrine());
		return archive;
	}

	private UsrMember getMemberFromArchive(ArchiveImportExcel archiveExcel,
			Long membId) {
		UsrMember member = new UsrMember();
		member.setMembId(membId);
		member.setAddress(archiveExcel.getAddress());
		return member;
	}

	private void addErrorMessage(ArchiveImportExcel archiveExcel,
			String reason, List<ArchiveErrorExcel> errors) {
		ArchiveErrorExcel error = new ArchiveErrorExcel(archiveExcel);
		error.setReason(reason);
		errors.add(error);
	}

	@Override
	public String downloadArchive(String name, String phone, String account,
			Integer archiveStatus, Date beginTime, Date endTime, Integer opStatus,
			String compName, String opName, Long addOpId, Long addRoleLevel,
			Long addCompId) {
		name = StringUtils.isEmpty(name) ? null : "%" + name + "%";
		account = StringUtils.isEmpty(account) ? null : "%" + account + "%";
		opName = StringUtils.isEmpty(opName) ? null : "%" + opName + "%";
		compName = StringUtils.isNotBlank(compName) ? "%" + compName + "%" : null;
		
		if(null == addRoleLevel){
			throw new SifudeException(SifudeLejaneExceptionEnum.PARAM_IS_NULL, "addRoleLevel");
		}
		
		List<UsrArchivesSMvo> archives = usrArchivesDao.search(name, phone, account, archiveStatus, beginTime, endTime,
				opStatus, compName, opName, 0, 1001, addOpId, addRoleLevel, addCompId);
		
		if(archives.size() > 1000) {
			throw new SifudeException(SifudeLejaneExceptionEnum.ARCHIVE_TOMANT_EXCEPATION, "1000");
		}
		
		List<ArchiveExportExcel> archiveExportExcels = new ArrayList<ArchiveExportExcel>();
		for(UsrArchivesSMvo archive : archives) {
			ArchiveExportExcel archiveExportExcel = converBean2Excel(archive);
			archiveExportExcels.add(archiveExportExcel);
		}
		String fileName = FileUtil.getFileName(".xlsx");
		log.trace(archiveExportExcels.size() + "");
		try {
			ExcelUtil.exportExcel(systemUtil.getArchiveDownloadPath() + fileName, ArchiveExportExcel.class, archiveExportExcels);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new SifudeException(SifudeLejaneExceptionEnum.OTHER_ERROR);
		}
		return fileName;
	}

	@Override
	public void downloadSearchArchive(String fileName, HttpServletResponse response) {
		FileUtil.download(response, "导出的档案.xls", systemUtil.getArchiveDownloadPath() + "/" + fileName);
	}

	private ArchiveExportExcel converBean2Excel(UsrArchivesSMvo bean) {
		ArchiveExportExcel excel = new ArchiveExportExcel();
		excel.setAddress(bean.getAddress());
		excel.setBooldFat(bean.getBooldFat());
		excel.setBooldSugar(bean.getBooldSugar());
		excel.setCharacteristic(bean.getCharacteristic());
		
		excel.setDescription(bean.getDescription());
		excel.setDigestion(bean.getDigestion());
		if(bean.getHealthStatus() == ArchivesHealthStatus.EXCELLENT.getValue()) {
			excel.setHealthStatus(ArchivesHealthStatus.EXCELLENT.getName());
		} else if(bean.getHealthStatus() == ArchivesHealthStatus.GOOD.getValue()) {
			excel.setHealthStatus(ArchivesHealthStatus.GOOD.getName());
		} else if(bean.getHealthStatus() == ArchivesHealthStatus.GENERAL.getValue()) {
			excel.setHealthStatus(ArchivesHealthStatus.GENERAL.getName());
		} else if(bean.getHealthStatus() == ArchivesHealthStatus.BAD.getValue()) {
			excel.setHealthStatus(ArchivesHealthStatus.BAD.getName());
		}
		if(bean.getHighPressure() != null) {
			excel.setHighPressure(String.valueOf(bean.getHighPressure()));
		}
		if(bean.getLowPressure() != null) {
			excel.setLowPressure(String.valueOf(bean.getLowPressure()));
		}
		if(bean.getIsDrink() == ArchivesDrinkStatus.YES.getValue()) {
			excel.setIsDrink(ArchivesDrinkStatus.YES.getName());	
		} else if(bean.getIsDrink() == ArchivesDrinkStatus.NO.getValue()) {
			excel.setIsDrink(ArchivesDrinkStatus.NO.getName());	
		}
		
		
		if(bean.getIsEatWell() == ArchivesEatStatus.YES.getValue()) {
			excel.setIsEatWell(ArchivesEatStatus.YES.getName());	
		} else if(bean.getIsEatWell() == ArchivesEatStatus.NO.getValue()) {
			excel.setIsEatWell(ArchivesEatStatus.NO.getName());	
		}
		
		if(bean.getIsMidnight() == ArchivesMidnightStatus.NO.getValue() && bean.getIsNap() == ArchivesNapStatus.NO.getValue()) {
			excel.setIsMidnightOrNap(null);
		} else if(bean.getIsMidnight() == ArchivesMidnightStatus.YES.getValue() && bean.getIsNap() == ArchivesNapStatus.NO.getValue()) {
			excel.setIsMidnightOrNap("熬夜");
		} else if(bean.getIsMidnight() == ArchivesMidnightStatus.NO.getValue() && bean.getIsNap() == ArchivesNapStatus.YES.getValue()) {
			excel.setIsMidnightOrNap("午睡");
		} else if(bean.getIsMidnight() == ArchivesMidnightStatus.YES.getValue() && bean.getIsNap() == ArchivesNapStatus.YES.getValue()) {
			excel.setIsMidnightOrNap("熬夜，午睡");
		}
		
		if(bean.getIsMove() == ArchivesMoveStatus.EVERY_DAY.getValue()) {
			excel.setIsMove(ArchivesMoveStatus.EVERY_DAY.getName());
		} else if(bean.getIsMove() == ArchivesMoveStatus.OFTEN.getValue()) {
			excel.setIsMove(ArchivesMoveStatus.OFTEN.getName());
		} else if(bean.getIsMove() == ArchivesMoveStatus.OCCASIONALLY.getValue()) {
			excel.setIsMove(ArchivesMoveStatus.OCCASIONALLY.getName());
		} else if(bean.getIsMove() == ArchivesMoveStatus.RARELY.getValue()) {
			excel.setIsMove(ArchivesMoveStatus.RARELY.getName());
		}
		
		if(bean.getIsSmoke() == ArchivesSmokeStatus.YES.getValue()) {
			excel.setIsSmoke(ArchivesSmokeStatus.YES.getName());	
		} else if(bean.getIsSmoke() == ArchivesSmokeStatus.NO.getValue()) {
			excel.setIsSmoke(ArchivesSmokeStatus.NO.getName());	
		}
		
		excel.setLimbsTemp(bean.getLimbsTemp());
		excel.setPhone(bean.getPhone());
		excel.setSleep(bean.getSleep());
		excel.setSleepHabbit(bean.getSleepHabbit());
		excel.setTongue(bean.getTongue());
		excel.setUrine(bean.getUrine());
		
		return excel;
	}

	@Override
	public void downloadFailArchive(String fileName,
			HttpServletResponse response) {
		FileUtil.download(response, "未导入的档案资料.xls", systemUtil.getArchiveErrorPath() + "/" + fileName);
	}

	@Override
	public void downloadTempArchive(HttpServletResponse response) {
		String path = this.getClass().getResource("").getPath();
		path = StringUtils.replace(path, "/service/impl/", "/temp/导入模板.xlsx");
		FileUtil.download(response, "导入模板.xlsx", path);
	}
	
	@Override
	public int addArchive(UsrArchives archives, UsrHabbit habbit) {
		int count = usrArchivesDao.save(archives);
		count += usrHabbitDao.save(habbit);
		UsrMember member = new UsrMember();
		member.setMembId(archives.getMembId());
		count += usrMemberDao.updateArchives(member); 
		return count;
	}

	@Override
	public int updateArchive(UsrArchives archives, UsrHabbit habbit) {
		int count = usrArchivesDao.update(archives);
		count += usrHabbitDao.update(habbit);
		
		return count;
	}

	@Override
	public UsrArchivesDMvo detailArchive(Long membId) {
		return usrArchivesDao.detail(membId);
	}

	@Override
	public List<UsrFamilyLMvo> listFamily(Long membId) {
		return usrFamilyDao.list(membId);
	}

	@Override
	public int saveFamily(UsrFamily family) {
		return usrFamilyDao.save(family);
	}

	@Override
	public int updateFamily(UsrFamily family) {
		return usrFamilyDao.update(family);
	}

	@Override
	public int deleteFamily(Long famId) {
		return usrFamilyDao.delete(famId);
	}

	@Override
	public int totalMember(Integer archiveStatus, Date beginTime, Date endTime,
			Long addOpId, Long addRoleLevel, Long addCompId) {
		return usrMemberDao.totalMember(null, null, null, archiveStatus, beginTime, endTime,
				null, null, null, addOpId, addRoleLevel, addCompId);
	}

	@Override
	public List<UsrErrorDataLMvo> listMemberData(Long addOpId) {
		return usrErrorDataDao.list(addOpId);
	}
	
	@Override
	public int updateMemberStatus(Long edId) {
		UsrErrorData data = new UsrErrorData();
		data.setIsRead(DataReadStatus.YES.getValue());
		data.setEdId(edId);
		return usrErrorDataDao.update(data);
	}
	
}
