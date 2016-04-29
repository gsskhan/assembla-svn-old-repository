package com.citi.ets.publisher.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citi.ets.publisher.dao.RtviewEtsAlertsDao;
import com.citi.ets.publisher.domain.AlertsView;
import com.citi.ets.publisher.domain.mapper.AlertsViewMapper;

/**
 * @author gk85985
 *
 */


@Repository("rtviewEtsAlertsDao")
public class RtviewEtsAlertsDaoImpl implements RtviewEtsAlertsDao {
		
	private Logger log = Logger.getLogger(RtviewEtsAlertsDaoImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * @return minimum timestamp
	 */
	public Timestamp getMinTimeOfAll() {
		String query = "select min(event_timestamp) from rtvhist.RTVIEW_ETS_ALERTS_VIEW";
		log.debug("Executing query ["+ query+"]");
		return this.jdbcTemplate.queryForObject(query, java.sql.Timestamp.class);
	}	


	/**
	 * @return List of AlertsView object
	 * @param time
	 * @param next
	 * */
	public List<AlertsView> getNextRecord(Timestamp time, boolean next) {
		if (next == true) 
			return this.jdbcTemplate.query(" select * from rtvhist.RTVIEW_ETS_ALERTS_VIEW "
					  + " where event_timestamp > ? order by event_timestamp asc "
					  , new Object[]{time},new AlertsViewMapper());					
		else
			return this.jdbcTemplate.query(" select * from rtvhist.RTVIEW_ETS_ALERTS_VIEW "
					+ " where event_timestamp >= ? order by event_timestamp asc "
					 , new Object[]{time},new AlertsViewMapper());	
	}
	

		
	// getter-setter methods
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
