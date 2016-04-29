package com.citi.ets.publisher.dao;

import java.sql.Timestamp;
import java.util.List;
import com.citi.ets.publisher.domain.AlertsView;

/**
 * 
 * @author gk85985
 * Dao for rts view
 */

public interface RtviewEtsAlertsDao {
	
	
	public Timestamp getMinTimeOfAll();	
	public List<AlertsView> getNextRecord( Timestamp time, boolean next );	

}
