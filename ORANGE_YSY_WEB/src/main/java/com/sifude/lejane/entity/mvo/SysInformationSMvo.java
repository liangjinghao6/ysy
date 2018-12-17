package com.sifude.lejane.entity.mvo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sifude.tool.util.json.JsonDateSerializer;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月23日 下午2:03:07 类说明
 */
public class SysInformationSMvo {

	private Long infoId;

	private String title;

	private String source;

	private String infoType;

	private String infoTime;

	private Integer checkStatus;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date checkTime;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date updateTime;

	private Long opId;

	private String opName;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date createTime;

	private Integer recordStatus;

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getInfoTime() {
		return infoTime;
	}

	public void setInfoTime(String infoTime) {
		this.infoTime = infoTime;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Integer recordStatus) {
		this.recordStatus = recordStatus;
	}

}
