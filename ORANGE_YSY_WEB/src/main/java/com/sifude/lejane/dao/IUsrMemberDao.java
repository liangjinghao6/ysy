package com.sifude.lejane.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sifude.lejane.entity.UsrMember;
import com.sifude.lejane.entity.excel.ArchiveImportExcel;
import com.sifude.lejane.entity.mvo.UsrMemberDMvo;
import com.sifude.lejane.entity.mvo.UsrMemberFMvo;
import com.sifude.lejane.entity.mvo.UsrMemberSMvo;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午5:00:11
 * 类说明
 */
@Repository("usrMemberDao")
public interface IUsrMemberDao {

	public UsrMemberDMvo detail(Long membId);

	public int save(UsrMember member);

	public int update(UsrMember member);

	public int updateArchives(UsrMember member);

	public Integer totalMember(@Param("name") String name, @Param("phone") String phone, @Param("account") String account,
			@Param("archiveStatus") Integer archiveStatus, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime, @Param("opStatus") Integer opStatus,
			@Param("compName") String compName, @Param("opName") String opName,
			@Param("addOpId") Long addOpId, @Param("addRoleLevel") Long addRoleLevel, @Param("addCompId") Long addCompId);

	public List<UsrMemberSMvo> searchMember(@Param("name") String name, @Param("phone") String phone, @Param("account") String account,
			@Param("archiveStatus") Integer archiveStatus, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime, @Param("opStatus") Integer opStatus,
			@Param("compName") String compName, @Param("opName") String opName,
			@Param("offset") int i, @Param("limit") Integer pageSize,
			@Param("addOpId") Long addOpId, @Param("addRoleLevel") Long addRoleLevel, @Param("addCompId") Long addCompId);

	public List<UsrMemberFMvo> filterPhone(@Param("archiveExcels") List<ArchiveImportExcel> archiveExcels, @Param("addCompId") Long addCompId);

}
