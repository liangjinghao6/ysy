package com.orange.ysy.entity.mvo;

import java.util.List;

import com.orange.ysy.entity.YsyGoods;
import com.orange.ysy.entity.YsyGoodsBrand;
import com.orange.ysy.entity.YsyGoodsCategory;
import com.orange.ysy.entity.YsyLnkGoodsClass;
import com.orange.ysy.entity.YsySysFile;

public class YsyGoodsMvo extends YsyGoods{
	private List<YsySysFile> simpleImage;
	private List<YsySysFile> detailsImage;
	private List<YsySysFile> wheelImage;
	private List<YsySysFile> extensionImage;
	private List<YsyGoodsFeatureMvo> features;
	private YsyGoodsBrand brand;
	private YsyGoodsCategory category;
	public List<YsySysFile> getSimpleImage() {
		return simpleImage;
	}
	public void setSimpleImage(List<YsySysFile> simpleImage) {
		this.simpleImage = simpleImage;
	}
	public List<YsySysFile> getDetailsImage() {
		return detailsImage;
	}
	public void setDetailsImage(List<YsySysFile> detailsImage) {
		this.detailsImage = detailsImage;
	}
	public List<YsySysFile> getWheelImage() {
		return wheelImage;
	}
	public void setWheelImage(List<YsySysFile> wheelImage) {
		this.wheelImage = wheelImage;
	}
	public List<YsySysFile> getExtensionImage() {
		return extensionImage;
	}
	public void setExtensionImage(List<YsySysFile> extensionImage) {
		this.extensionImage = extensionImage;
	}

	public List<YsyGoodsFeatureMvo> getFeatures() {
		return features;
	}
	public void setFeatures(List<YsyGoodsFeatureMvo> features) {
		this.features = features;
	}
	public YsyGoodsBrand getBrand() {
		return brand;
	}
	public void setBrand(YsyGoodsBrand brand) {
		this.brand = brand;
	}
	public YsyGoodsCategory getCategory() {
		return category;
	}
	public void setCategory(YsyGoodsCategory category) {
		this.category = category;
	}

}
