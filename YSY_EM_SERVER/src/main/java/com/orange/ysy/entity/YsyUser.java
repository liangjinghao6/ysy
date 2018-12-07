package com.orange.ysy.entity;

import java.util.Date;

public class YsyUser {
    private String userId;

	private String userName;

	private Boolean isVip;

	private String nickName;

	private String userWx;

	private Short userLevel;

	private String inviteCode;

	private String parentId;

	private Date invitedTime;

	private Date vipTime;

	private String token;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public Boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName == null ? null : nickName.trim();
	}

	public String getUserWx() {
		return userWx;
	}

	public void setUserWx(String userWx) {
		this.userWx = userWx == null ? null : userWx.trim();
	}

	public Short getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Short userLevel) {
		this.userLevel = userLevel;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode == null ? null : inviteCode.trim();
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}

	public Date getInvitedTime() {
		return invitedTime;
	}

	public void setInvitedTime(Date invitedTime) {
		this.invitedTime = invitedTime;
	}

	public Date getVipTime() {
		return vipTime;
	}

	public void setVipTime(Date vipTime) {
		this.vipTime = vipTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}

}