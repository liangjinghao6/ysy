package com.sifude.lejane.entity.mvo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sifude.tool.util.json.JsonTimeSerializer;

/**
 * @author 梁景皓
 * @version 创建时间：2016年4月8日 下午3:08:12 类说明
 */
public class UsrErrorDataLMvo {
	private Long edId;
	private Long membId;
	private String membName;
	private String dataDesc;
	@JsonSerialize(using = JsonTimeSerializer.class)
	private Date checkTime;
	public Long getEdId() {
		return edId;
	}
	public void setEdId(Long edId) {
		this.edId = edId;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getMembName() {
		return membName;
	}
	public void setMembName(String membName) {
		this.membName = membName;
	}
	public String getDataDesc() {
		return dataDesc;
	}
	public void setDataDesc(String dataDesc) {
		this.dataDesc = dataDesc;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
}
