package com.orange.ysy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class YsyOpOperator {
    /**
     * 管理员id
     */
    private String operatorId;

    /**
     * 管理员账户
     */
    private String account;

    /**
     * 管理员组织
     */
    private String companyId;

    /**
     * 管理员姓名
     */
    private String name;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 是否锁定
     */
    private Boolean isLock;

    /**
     * 是否停用
     */
    private Boolean isStop;

    /**
     * 是否密码过期
     */
    private Boolean isPwdExpire;

    /**
     * 密码有效时长
     */
    private Short pwdDuration;

    /**
     * 密码修改时间
     */
    private Date pwdTime;

    /**
     * 登录是否改密
     */
    private Boolean isPwdChange;

    /**
     * 账号是否过期
     */
    private Boolean isAccountExpire;

    /**
     * 账号有效时间
     */
    private Date accountTime;

    /**
     * 皮肤
     */
    private Short skin;

    /**
     * 语言
     */
    private Short language;

    /**
     * token
     */
    private String token;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 记录状态
     */
    private Short recordStatus;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public Boolean getIsStop() {
        return isStop;
    }

    public void setIsStop(Boolean isStop) {
        this.isStop = isStop;
    }

    public Boolean getIsPwdExpire() {
        return isPwdExpire;
    }

    public void setIsPwdExpire(Boolean isPwdExpire) {
        this.isPwdExpire = isPwdExpire;
    }

    public Short getPwdDuration() {
        return pwdDuration;
    }

    public void setPwdDuration(Short pwdDuration) {
        this.pwdDuration = pwdDuration;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Date getPwdTime() {
        return pwdTime;
    }

    public void setPwdTime(Date pwdTime) {
        this.pwdTime = pwdTime;
    }

    public Boolean getIsPwdChange() {
        return isPwdChange;
    }

    public void setIsPwdChange(Boolean isPwdChange) {
        this.isPwdChange = isPwdChange;
    }

    public Boolean getIsAccountExpire() {
        return isAccountExpire;
    }

    public void setIsAccountExpire(Boolean isAccountExpire) {
        this.isAccountExpire = isAccountExpire;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    public Short getSkin() {
        return skin;
    }

    public void setSkin(Short skin) {
        this.skin = skin;
    }

    public Short getLanguage() {
        return language;
    }

    public void setLanguage(Short language) {
        this.language = language;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Short recordStatus) {
        this.recordStatus = recordStatus;
    }
}