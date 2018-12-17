package com.orange.ysy.entity;

import java.util.Date;

public class YsyLnkGoodsImage {
    /**
     * 关联id
     */
    private String giId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 图片id
     */
    private String imageId;

    /**
     * 图片类型
     */
    private Short imageType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 
     */
    private Short recordStatus;

    public String getGiId() {
        return giId;
    }

    public void setGiId(String giId) {
        this.giId = giId == null ? null : giId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
    }

    public Short getImageType() {
        return imageType;
    }

    public void setImageType(Short imageType) {
        this.imageType = imageType;
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

    public Short getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Short recordStatus) {
        this.recordStatus = recordStatus;
    }
}