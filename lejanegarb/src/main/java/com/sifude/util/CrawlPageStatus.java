package com.sifude.util;

public enum CrawlPageStatus {
	/**
	 * 未处理，可变为处理中状态
	 */
	NORMAL("未处理", 0),
	/**
	 * 处理中，可以变成处理成功状态和处理失败状态
	 */
	DEALING("处理成功", 1), 
	/**
	 * 分析列表完成,可以变成处理完成状态和处理失败
	 */
	SUCCESS("处理成功", 2), 
	/**
	 * 分析资讯完成，可以变成未处理状态（重新抓取）
	 */
	FINISH("处理完成", 3),
	/**
	 * 处理失败,可以变成未处理状态重新处理
	 */
	FAIL("处理失败", -1);
	private String name;
	private int value;

	private CrawlPageStatus(String name, int value) {
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
