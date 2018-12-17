package com.orange.ysy.enumerate;

public enum ImageStatus {
	UPLOADING("开始上传", 0), UPLOAD_SUCCESS("上传完成", 1), UPLOAD_FAIL("上传失败", -1),
	DEALING("开始解析", 2), DEAL_SUCCESS("解析成功", 3), DEAL_FAIL("解析失败", -2);
	private String name;
	private Short value;

	private ImageStatus(String name, Integer value) {
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