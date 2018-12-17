package com.orange.ysy.entity;

import java.util.Date;

public class YsyLnkBackGoods {
    /**
     * 关联id
     */
    private String bgId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 商品数量
     */
    private Short goodsNum;

    /**
     * 退货单id
     */
    private String backId;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getBgId() {
        return bgId;
    }

    public void setBgId(String bgId) {
        this.bgId = bgId == null ? null : bgId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Short getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Short goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getBackId() {
        return backId;
    }

    public void setBackId(String backId) {
        this.backId = backId == null ? null : backId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}