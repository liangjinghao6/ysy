package com.orange.ysy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class YsyLnkUserGoods {
    /**
     * 
     */
    private String uiId;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String goodsId;

    /**
     * 
     */
    private Date createTime;

    public String getUiId() {
        return uiId;
    }

    public void setUiId(String uiId) {
        this.uiId = uiId == null ? null : uiId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}