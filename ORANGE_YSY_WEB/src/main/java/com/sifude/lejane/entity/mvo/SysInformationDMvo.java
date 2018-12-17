package com.sifude.lejane.entity.mvo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sifude.lejane.entity.SysInformation;
import com.sifude.tool.util.json.JsonDateSerializer;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月23日 下午2:03:47
 * 类说明
 */
public class SysInformationDMvo extends SysInformation{
	@JsonIgnore
	private Date checkTime;
	
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
}
