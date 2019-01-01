package com.orange.ysy.enumerate;

public enum GoodsImageType {
	SIMPLE("缩略图", 1), DETAILS("详情图", 2), WHEEL("轮播图", 3),
	EXTENSION("推广图", 4);
	private String name;
	private Short value;

	
	private GoodsImageType(String name, Integer value) {
		this.name = name;
		this.value = value.shortValue();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getValue() {
		return value;
	}

	public void setValue(Short value) {
		this.value = value;
	}
}