package com.citi.ets.publisher.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import com.citi.ets.publisher.domain.AlertsView;

/**
 * @author gk85985
 * Mapper for AlertsView
 */
public class AlertsViewMapper implements RowMapper<AlertsView>{
	
	private Logger log = Logger.getLogger(AlertsViewMapper.class);

	public AlertsView mapRow(ResultSet rs, int rownum) throws SQLException {
		AlertsView alertsView = new AlertsView();
		alertsView.setCsiId(rs.getLong("CSIID"));
		alertsView.setShortname(rs.getString("SHORTNAME"));
		alertsView.setComponent(rs.getString("COMPONENT"));
		alertsView.setKpi(rs.getString("KPI"));
		alertsView.setEventTimestamp(rs.getTimestamp("EVENT_TIMESTAMP"));
		alertsView.setAppDescription(rs.getString("ALERT_DESCRIPTION"));
		alertsView.setAlertValue(rs.getString("ALERT_VALUE"));
		alertsView.setSeverity(rs.getLong("SEVERITY"));
		alertsView.setCleared(rs.getLong("CLEARED"));
		log.debug("Row No. ="+rownum+" , AlertsView = "+  alertsView);
		return alertsView;
	}
	
	
	
	

}
