package com.citi.retail.optima.etl.batch.job.infra;

import org.springframework.batch.item.file.transform.FieldSet;

public class BatchJobUtil {

	public static String getRecordStringFromFieldSet(FieldSet fieldSet) {
		String[] stringArr = fieldSet.getValues();
		StringBuilder strBuild = new StringBuilder();

		for (int i = 0; i < stringArr.length; i++) {
			strBuild.append(stringArr[i]);
			if (stringArr.length - 1 != i) {
				strBuild.append(",");
			}
		}

		return strBuild.toString().replaceAll("null", "");
	}

}
