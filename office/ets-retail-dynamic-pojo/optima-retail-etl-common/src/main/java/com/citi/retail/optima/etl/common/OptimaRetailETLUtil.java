package com.citi.retail.optima.etl.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class OptimaRetailETLUtil {

	private static final Log LOGGER = LogFactory
			.getLog(OptimaRetailETLUtil.class);

	/**
	 * Private Constructor to avoid Sonar violation for Utility classes
	 */
	private OptimaRetailETLUtil() {
	}

	public static Date convertDate(java.sql.Date dateObj) {
		Date utilDate = null;
		if (dateObj != null) {
			utilDate = new Date(dateObj.getTime());
		}
		return utilDate;
	}

	public static Date convertDateFormat(String dateString, String format) {

		DateFormat df = new SimpleDateFormat(format);
		Date parsedDate = null;
		try {
			parsedDate = df.parse(dateString);
		} catch (ParseException e) {
			LOGGER.error("Exception occured while loading OptimaRetailETLUtil "
					+ e.getMessage());
		}

		return parsedDate;

	}

	public static Date getLastDayOfMonth(java.util.Date reportPeriod) {
		Calendar calendar = null;
		calendar = Calendar.getInstance();
		calendar.setTime(reportPeriod);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);

		return new Date(calendar.getTime().getTime());
	}

	public static String formatDate(Date reportPeriod) {
		DateFormat df = new SimpleDateFormat("yyyyMM");
		return df.format(reportPeriod);
	}

	public static java.sql.Date getLast24MonthDate(Date reportPeriod) {

		Calendar calendar = null;
		calendar = Calendar.getInstance();
		calendar.setTime(reportPeriod);
		calendar.add(Calendar.MONTH, -24);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		return new java.sql.Date(calendar.getTime().getTime());
	}

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyyMM");
		Date dt = new Date(System.currentTimeMillis());
		LOGGER.info("INFO -->" + df.format(dt));
	}

}
