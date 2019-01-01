/*
 * Copyright © 2015 HUADONG SOFT-TECH CO.,LTD.
 * All Rights Reserved
 */
package com.orange.ysy.util;

import java.util.UUID;

/**
 * 生成一组uuid
 * 
 * @author DELL
 */
public class CreateId {
	public static String Uuid() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
}
