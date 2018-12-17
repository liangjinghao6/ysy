package com.sifude.lejanel.sanjiu.model;  

import java.util.Date;
  
public class SysCrawlUrl {
	private Long craId;
	private String url;
	private String type;
	private String attribute;
	private Integer status;
	private Date createTime;
	public Long getCraId() {
		return craId;
	}
	public void setCraId(Long craId) {
		this.craId = craId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
