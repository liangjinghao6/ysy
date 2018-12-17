package com.sifude.lejane.status;
/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午8:10:31
 * 类说明
 */
public enum ArchivesMoveStatus {
	EVERY_DAY("天天锻炼", 0), OFTEN("经常锻炼", 1), OCCASIONALLY("偶尔", 2), RARELY("很少", 3);
	
	private String name;
	private Integer value;

	private ArchivesMoveStatus(String name, Integer value) {
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
