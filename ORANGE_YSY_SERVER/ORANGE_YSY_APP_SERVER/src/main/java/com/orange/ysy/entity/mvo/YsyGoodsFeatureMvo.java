package com.orange.ysy.entity.mvo;

import java.util.List;

import com.orange.ysy.entity.YsyGoodsClass;
import com.orange.ysy.entity.YsyGoodsFeature;

public class YsyGoodsFeatureMvo extends YsyGoodsFeature{
	private List<YsyGoodsClass> classes;

	public List<YsyGoodsClass> getClasses() {
		return classes;
	}

	public void setClasses(List<YsyGoodsClass> classes) {
		this.classes = classes;
	}
	
}
