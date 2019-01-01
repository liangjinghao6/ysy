package com.orange.ysy.entity.mvo;

import java.util.List;

import com.orange.ysy.entity.YsyGoods;

public class YsyGoodsMvo extends YsyGoods{
	private List<String> simpleImage;
	private List<String> detailsImage;
	private List<String> wheelImage;
	private List<String> extensionImage;
	private List<String> classes;
	public List<String> getSimpleImage() {
		return simpleImage;
	}
	public void setSimpleImage(List<String> simpleImage) {
		this.simpleImage = simpleImage;
	}
	public List<String> getDetailsImage() {
		return detailsImage;
	}
	public void setDetailsImage(List<String> detailsImage) {
		this.detailsImage = detailsImage;
	}
	public List<String> getWheelImage() {
		return wheelImage;
	}
	public void setWheelImage(List<String> wheelImage) {
		this.wheelImage = wheelImage;
	}
	public List<String> getExtensionImage() {
		return extensionImage;
	}
	public void setExtensionImage(List<String> extensionImage) {
		this.extensionImage = extensionImage;
	}
	public List<String> getClasses() {
		return classes;
	}
	public void setClasses(List<String> classes) {
		this.classes = classes;
	}
	
}
