package com.sangebang.water.util;

import java.util.UUID;

public class GetUUID {
	public static String getUUID() {
		/*
		 * UUID uuid = UUID.randomUUID(); String str = uuid.toString(); //
		 * ȥ��"-"���� String temp = str.substring(0, 8) + str.substring(9, 13) +
		 * str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
		 * return temp;
		 */

		return UUID.randomUUID().toString().replace("-", "");

	}
}
