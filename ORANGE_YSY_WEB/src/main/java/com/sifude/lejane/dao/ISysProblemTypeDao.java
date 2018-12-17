package com.sifude.lejane.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sifude.lejane.entity.SysProblemType;
import com.sifude.lejane.entity.mvo.SysProblemTypeLMvo;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月23日 上午11:27:22
 * 类说明
 */
@Repository("sysProblemTypeDao")
public interface ISysProblemTypeDao {

	List<SysProblemTypeLMvo> list(@Param("name") String name, @Param("limit") Integer size);

	int save(SysProblemType problem);

}
