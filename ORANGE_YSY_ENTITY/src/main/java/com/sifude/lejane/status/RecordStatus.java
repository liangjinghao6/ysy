package com.sifude.lejane.status;

public enum RecordStatus {
	NORMAL("正常", 0), DELETE("删除", -1), REMOVE("彻底删除", -2);
	private String name;
	private int value;

	private RecordStatus(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
