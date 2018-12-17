package com.sifude.lejane.status;
/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午8:10:31
 * 类说明
 */
public enum ArchivesEatStatus {
	YES("规律", 1), NO("不规律", 0);
	
	private String name;
	private Integer value;

	private ArchivesEatStatus(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
