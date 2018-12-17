package com.sifude.lejane.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.sifude.lejane.entity.UsrArchives;
import com.sifude.lejane.entity.UsrFamily;
import com.sifude.lejane.entity.UsrHabbit;
import com.sifude.lejane.entity.UsrMember;
import com.sifude.lejane.entity.mvo.UsrArchivesDMvo;
import com.sifude.lejane.entity.mvo.UsrArchivesUMvo;
import com.sifude.lejane.entity.mvo.UsrErrorDataLMvo;
import com.sifude.lejane.entity.mvo.UsrFamilyLMvo;
import com.sifude.lejane.entity.mvo.UsrMemberDMvo;
import com.sifude.lejane.entity.mvo.UsrMemberSMvo;
import com.sifude.tool.util.entity.PageBean;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午3:52:50
 * 类说明
 */
public interface IMemberService {

	PageBean<UsrMemberSMvo> searchMember(String name, String phone,
			String account, Integer archiveStatus, Date beginTime, Date endTime,
			Integer opStatus, String compName, String opName,
			Integer pageIndex, Integer pageSize, Long addOpId,
			Long addRoleLevel, Long addCompId);

	UsrMemberDMvo detailMember(Long membId);

	int addMember(UsrMember member);

	int updateMember(UsrMember member);

	UsrArchivesUMvo uploadArchive(MultipartFile file, Long addCompId);

	void downloadFailArchive(String fileName, HttpServletResponse response);

	int addArchive(UsrArchives archives, UsrHabbit habbit);

	int updateArchive(UsrArchives archives, UsrHabbit habbit);

	UsrArchivesDMvo detailArchive(Long membId);

	List<UsrFamilyLMvo> listFamily(Long membId);

	int saveFamily(UsrFamily family);

	int updateFamily(UsrFamily family);

	int deleteFamily(Long famId);

	int totalMember(Integer archiveStatus, Date beginTime, Date endTime,
			Long addOpId, Long addRoleLevel, Long addCompId);

	void downloadTempArchive(HttpServletResponse response);

	void downloadSearchArchive(String fileName, HttpServletResponse response);

	String downloadArchive(String name, String phone, String account,
			Integer archiveStatus, Date beginTime, Date endTime,
			Integer opStatus, String compName, String opName, Long addOpId,
			Long addRoleLevel, Long addCompId);

	List<UsrErrorDataLMvo> listMemberData(Long addOpId);

	int updateMemberStatus(Long edId);

}
