package com.sifude.lejane.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sifude.lejane.entity.UsrArchives;
import com.sifude.lejane.entity.mvo.UsrArchivesDMvo;
import com.sifude.lejane.entity.mvo.UsrArchivesSMvo;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午5:00:11
 * 类说明
 */
@Repository("usrArchivesDao")
public interface IUsrArchivesDao {

	public int save(UsrArchives archive);

	public int update(UsrArchives archives);

	public UsrArchivesDMvo detail(Long membId);

	public List<UsrArchivesSMvo> search(@Param("name") String name, @Param("phone") String phone,
			@Param("account") String account, @Param("archiveStatus") Integer archiveStatus, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime,
			@Param("opStatus") Integer opStatus, @Param("compName") String compName, @Param("opName") String opName, @Param("offset") int offset, @Param("limit") int limit,
			@Param("addOpId") Long addOpId, @Param("addRoleLevel") Long addRoleLevel, @Param("addCompId") Long addCompId);

}
