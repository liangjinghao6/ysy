package com.orange.ysy.entity.mvo;

import java.util.List;

import com.orange.ysy.entity.YsyGoods;
import com.orange.ysy.entity.YsyLnkGoodsClass;
import com.orange.ysy.entity.YsySysFile;

public class YsyGoodsMvo extends YsyGoods{
	private List<YsySysFile> simpleImage;
	private List<YsySysFile> detailsImage;
	private List<YsySysFile> wheelImage;
	private List<YsySysFile> extensionImage;
	private List<YsyLnkGoodsClass> classes;
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
	public List<YsyLnkGoodsClass> getClasses() {
		return classes;
	}
	public void setClasses(List<YsyLnkGoodsClass> classes) {
		this.classes = classes;
	}
	
}
