package com.sifude.lejane.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sifude.lejane.entity.SysProblem;
import com.sifude.lejane.entity.mvo.SysProblemDMvo;
import com.sifude.lejane.entity.mvo.SysProblemLMvo;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月22日 下午6:07:58
 * 类说明
 */
@Repository("sysProblemDao")
public interface ISysProblemDao {

	Integer total(@Param("title") String title, @Param("ptId")Long ptId,
			@Param("beginTime") Date beginTime, @Param("endTime")Date endTime,
			@Param("addCompId") Long addCompId);

	List<SysProblemLMvo> search(@Param("title") String title, @Param("ptId")Long ptId,
			@Param("beginTime") Date beginTime, @Param("endTime")Date endTime,
			@Param("addCompId") Long addCompId,
			@Param("offset") Integer i, @Param("limit") Integer pageSize);

	SysProblemDMvo detail(Long proId);

	int save(SysProblem problem);

	int update(SysProblem problem);

	int exist(String name);

}
