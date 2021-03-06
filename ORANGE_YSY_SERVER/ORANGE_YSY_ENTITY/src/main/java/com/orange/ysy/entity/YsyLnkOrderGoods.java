package com.orange.ysy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class YsyLnkOrderGoods {
    /**
     * 关联id
     */
    private String odId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 商品编号
     */
    private Integer goodsNo;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Short goodsNum;

    /**
     * 商品图片
     */
    private String goodsImage;

    /**
     * 标记价格
     */
    private Double marketPrice;

    /**
     * 实际价格
     */
    private Double realPrice;

    /**
     * 商品特征值名称
     */
    private String classNames;

    /**
     * 商品特征值id
     */
    private String classIds;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getOdId() {
        return odId;
    }

    public void setOdId(String odId) {
        this.odId = odId == null ? null : odId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Integer getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(Integer goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Short getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Short goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public String getClassNames() {
        return classNames;
    }

    public void setClassNames(String classNames) {
        this.classNames = classNames == null ? null : classNames.trim();
    }

    public String getClassIds() {
        return classIds;
    }

    public void setClassIds(String classIds) {
        this.classIds = classIds == null ? null : classIds.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}