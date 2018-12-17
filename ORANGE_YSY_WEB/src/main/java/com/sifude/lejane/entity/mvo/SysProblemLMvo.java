package com.sifude.lejane.entity.mvo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sifude.tool.util.json.JsonDateSerializer;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月22日 下午5:28:35
 * 类说明
 */
public class SysProblemLMvo{
    private Long proId;

    private String title;

    private Long ptId;

    private String type;
    
    private String content;

	@JsonSerialize(using = JsonDateSerializer.class)
    private Date createTime;

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPtId() {
		return ptId;
	}

	public void setPtId(Long ptId) {
		this.ptId = ptId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
