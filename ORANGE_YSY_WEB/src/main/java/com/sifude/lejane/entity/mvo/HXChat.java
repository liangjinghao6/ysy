package com.sifude.lejane.entity.mvo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author 梁景皓
 * @version 创建时间：2015年9月25日 下午3:38:01
 * 类说明
 */
@JsonInclude(Include.NON_NULL)
public class HXChat {
	private String uuid;
	private String type;
	private Long created;
	private Long modified;
	private Long timestamp;
	private String from;
	private String msg_id;
	private String to;
	private String chat_type;
	private HXChatPayload payload;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getCreated() {
		return created;
	}
	public void setCreated(Long created) {
		this.created = created;
	}
	public Long getModified() {
		return modified;
	}
	public void setModified(Long modified) {
		this.modified = modified;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getChat_type() {
		return chat_type;
	}
	public void setChat_type(String chat_type) {
		this.chat_type = chat_type;
	}
	public HXChatPayload getPayload() {
		return payload;
	}
	public void setPayload(HXChatPayload payload) {
		this.payload = payload;
	}
}
