package com.sifude.lejane.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sifude.lejane.entity.SysInformation;
import com.sifude.lejane.entity.mvo.SysInformationDMvo;
import com.sifude.lejane.entity.mvo.SysInformationSMvo;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月23日 下午2:14:00
 * 类说明
 */
@Repository("sysInformationDao")
public interface ISysInformationDao {

	Integer total(@Param("title") String title, @Param("type") String Type,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime,
			@Param("status") Integer status);

	List<SysInformationSMvo> search(@Param("title") String title, @Param("type") String Type,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime,
			@Param("status") Integer status, @Param("offset") int i, @Param("limit") Integer pageSize);

	SysInformationDMvo detail(Long infoId);

	int update(SysInformation information);

	int save(SysInformation information);

	int delete(Long infoId);

}
