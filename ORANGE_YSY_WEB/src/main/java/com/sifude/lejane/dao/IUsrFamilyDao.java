package com.sifude.lejane.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sifude.lejane.entity.UsrFamily;
import com.sifude.lejane.entity.mvo.UsrFamilyLMvo;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月30日 上午9:55:26
 * 类说明
 */
@Repository("usrFamilyDao")
public interface IUsrFamilyDao {
	
	List<UsrFamilyLMvo> list(Long membId);

	int save(UsrFamily family);

	int update(UsrFamily family);

	int delete(Long famId);

}
