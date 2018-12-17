package com.orange.ysy.entity;

import java.util.Date;

public class YsyUser {
    private String userId;

    private String userName;

    private String nickName;

    private Byte isVip;

    private String wxNo;

    private Short userLevel;

    private Integer inviteNo;

    private String inviteId;

    private Date createTime;

    private Date updateTime;

    private Date inviteTime;

    private Date vipTime;

    private String token;

    private Short recordStatus;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Byte getIsVip() {
        return isVip;
    }

    public void setIsVip(Byte isVip) {
        this.isVip = isVip;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo == null ? null : wxNo.trim();
    }

    public Short getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Short userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getInviteNo() {
        return inviteNo;
    }

    public void setInviteNo(Integer inviteNo) {
        this.inviteNo = inviteNo;
    }

    public String getInviteId() {
        return inviteId;
    }

    public void setInviteId(String inviteId) {
        this.inviteId = inviteId == null ? null : inviteId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(Date inviteTime) {
        this.inviteTime = inviteTime;
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

    public Short getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Short recordStatus) {
        this.recordStatus = recordStatus;
    }
}