package com.orange.ysy.util;

import java.util.Random;

/**
 * @author liangjh
 * @date 2017年6月20日 下午4:18:18
 * @description
 */
public class RandomUtil {

	private static Random r = new Random();

	public static int getRandomNum(int size) {

		// TODO Auto-generated method stub
		return r.nextInt(size);
	}

	public static void main(String[] args) {
		System.out.println(r.nextInt(22));
	}

}
