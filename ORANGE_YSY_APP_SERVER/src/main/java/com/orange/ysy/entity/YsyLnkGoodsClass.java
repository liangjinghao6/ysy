package com.orange.ysy.entity;

import java.util.Date;

public class YsyLnkGoodsClass {
    /**
     * 关联id
     */
    private String gcId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 类别id
     */
    private String classId;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getGcId() {
        return gcId;
    }

    public void setGcId(String gcId) {
        this.gcId = gcId == null ? null : gcId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}