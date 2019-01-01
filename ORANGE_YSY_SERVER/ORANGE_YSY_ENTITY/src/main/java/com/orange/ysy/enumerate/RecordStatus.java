package com.orange.ysy.enumerate;

public enum RecordStatus {
	NORMAL("正常", 0), DELETE("删除", -1), REMOVE("彻底删除", -2), FAIL("上传失败", -3), SUCCESS("上传成功", 1);
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

	public short getValue() {
		return (short) value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
