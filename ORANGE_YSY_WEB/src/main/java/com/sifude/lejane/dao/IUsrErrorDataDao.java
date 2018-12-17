package com.sifude.lejane.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sifude.lejane.entity.UsrErrorData;
import com.sifude.lejane.entity.mvo.UsrErrorDataLMvo;

/**
 * @author 梁景皓
 * @version 创建时间：2016年4月8日 下午3:06:33
 * 类说明
 */
@Repository("usrErrorDataDao")
public interface IUsrErrorDataDao {
	public List<UsrErrorDataLMvo> list(Long addOpId);
	
	public int update(UsrErrorData data);
}
