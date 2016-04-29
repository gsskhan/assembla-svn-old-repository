package com.citi.retail.optima.etl.common.test.reflection.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockEnrichmentProvider {

	private static Logger LOGGER = LoggerFactory
			.getLogger(MockEnrichmentProvider.class);

	/**
	 * This method returns the band value for Months on Book when passed with a
	 * Months on Book argument.
	 * 
	 * @param monthsOnBook
	 * @return months on Book Band Value
	 */
	public static int getCardsMobBand(int monthsOnBook) {
		int mobBand = -1;

		if (monthsOnBook >= 0) {
			if ((monthsOnBook + 1) <= 60) {
				mobBand = (int) Math.ceil((monthsOnBook + 1) / 3);
			} else if ((monthsOnBook + 1) <= 120) {
				mobBand = (int) Math.ceil(((monthsOnBook + 1) - 60) / 6) + 20;
			} else if ((monthsOnBook + 1) <= 180) {
				mobBand = (int) Math.ceil(((monthsOnBook + 1) - 120) / 12) + 30;
			} else if ((monthsOnBook + 1) <= 360) {
				mobBand = (int) Math.ceil(((monthsOnBook + 1) - 180) / 36) + 35;
			} else {
				mobBand = 41;
			}
			LOGGER.debug("getCardsMobBand: Returning " + mobBand
					+ " for monthsOnBook value of " + monthsOnBook);
			return mobBand;

		} else {
			LOGGER.debug("getCardsMobBand: Returning -1 as monthsOnBook value passed in was "
					+ monthsOnBook);
			return mobBand;
		}

	}
}
