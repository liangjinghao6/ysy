package com.sifude.lejane.dao;

import org.springframework.stereotype.Repository;

import com.sifude.lejane.entity.UsrHabbit;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午5:00:11
 * 类说明
 */
@Repository("usrHabbitDao")
public interface IUsrHabbitDao {

	public int save(UsrHabbit habbit);

	public int update(UsrHabbit habbit);

}
