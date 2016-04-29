/**
 * 
 */
package com.citi.retail.optima.etl.common.log;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @author gv74035 Enum to represent different marker constants for logback
 */
public enum LoggingMarker {

	SMTP("SMTP"), CONSOLE("CONSOLE"), CHECKPOINTS("CHECKPOINTS"),JMS("JMS"),KPI("KPI");

	private Marker marker;

	private LoggingMarker(String type) {
		this.marker = MarkerFactory.getMarker(type);
	}

	public Marker getMarker() {
		return this.marker;
	}
}
