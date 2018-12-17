package com.sifude.lejane.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sifude.lejane.entity.SysFeedback;
import com.sifude.lejane.entity.mvo.SysFeedbackDMvo;
import com.sifude.lejane.entity.mvo.SysFeedbackSMvo;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月24日 上午10:59:34
 * 类说明
 */
@Repository("sysFeedbackDao")
public interface ISysFeedbackDao {

	Integer total(@Param("ptId") Long ptId, @Param("beginTime") Date beginTime,
			@Param("endTime") Date endTime, @Param("addCompId") Long addCompId);

	List<SysFeedbackSMvo> search(@Param("ptId") Long ptId, @Param("beginTime") Date beginTime,
			@Param("endTime") Date endTime, @Param("addCompId") Long addCompId,
			@Param("offset") int i, @Param("limit") Integer pageSize);

	SysFeedbackDMvo detail(Long proId);

	int save(SysFeedback feedback);

	int update(SysFeedback feedback);

}
