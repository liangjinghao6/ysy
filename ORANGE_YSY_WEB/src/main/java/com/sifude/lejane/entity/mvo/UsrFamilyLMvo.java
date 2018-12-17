package com.sifude.lejane.entity.mvo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sifude.lejane.entity.UsrFamily;
import com.sifude.tool.util.json.JsonDateSerializer;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午6:00:27
 * 类说明
 */
public class UsrFamilyLMvo extends UsrFamily{

	@JsonSerialize(using = JsonDateSerializer.class)
    private Date birthday;
	@JsonIgnore
    private Date createTime;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
