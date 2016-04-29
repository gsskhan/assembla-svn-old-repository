package com.citi.retail.optima.etl.common.log;

import org.slf4j.Marker;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author sr67841 This is the filter class for console appender
 */
@SuppressWarnings("rawtypes")
public class DebugFilter extends
		ch.qos.logback.core.filter.AbstractMatcherFilter {
	@Override
	public FilterReply decide(Object event) {
		LoggingEvent loggingEvent = (LoggingEvent) event;
		Marker marker = loggingEvent.getMarker();
		FilterReply reply = FilterReply.DENY;
		if (marker != null
				&& marker.getName().equals(
						LoggingMarker.CHECKPOINTS.getMarker().getName())) {
			reply = FilterReply.ACCEPT;
		}

		return reply;
	}
}