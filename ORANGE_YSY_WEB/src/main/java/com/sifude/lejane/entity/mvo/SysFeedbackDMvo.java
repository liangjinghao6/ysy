package com.sifude.lejane.entity.mvo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sifude.lejane.entity.SysFeedback;
import com.sifude.tool.util.json.JsonDateSerializer;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月24日 上午10:24:11 类说明
 */
public class SysFeedbackDMvo extends SysFeedback {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCreateTime() {
		return super.getCreateTime();
	}
}
