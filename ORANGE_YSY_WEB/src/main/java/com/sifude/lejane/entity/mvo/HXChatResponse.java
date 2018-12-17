package com.sifude.lejane.entity.mvo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author 梁景皓
 * @version 创建时间：2015年9月25日 下午3:48:55
 * 类说明
 */
@JsonInclude(Include.NON_NULL)
public class HXChatResponse {
	private String action;
	private String path;
	private Object params;
	private String uri;
	private List<HXChat> entities;
	private Long timestamp;
	private String duration;
	private int count;
	private String cursor;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Object getParams() {
		return params;
	}
	public void setParams(Object params) {
		this.params = params;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public List<HXChat> getEntities() {
		return entities;
	}
	public void setEntities(List<HXChat> entities) {
		this.entities = entities;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCursor() {
		return cursor;
	}
	public void setCursor(String cursor) {
		this.cursor = cursor;
	}
	@Override
	public String toString() {
		return "HXChatResponse [action=" + action + ", path=" + path + ", uri="
				+ uri + ", entities=" + entities + ", timestamp=" + timestamp
				+ ", duration=" + duration + ", count=" + count + ", cursor="
				+ cursor + "]";
	}
	
}
