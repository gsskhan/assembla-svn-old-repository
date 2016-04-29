package com.citi.retail.optima.etl.cache.ehcache;

public class OptimaCacheUtil {

	public static String keyCreator(Object... vars) {

		StringBuilder keyString = new StringBuilder();

		int i = 1;
		for (Object var : vars) {
			if (var != null) {
				keyString.append(var.toString().toLowerCase().trim());
				if (vars.length != i) {
					keyString.append(",");
				}
			} else {
				if (vars.length != i) {
					keyString.append(",");
				}
			}
			i++;
		}
		return keyString.toString();

	}

}
