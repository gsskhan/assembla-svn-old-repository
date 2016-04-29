package com.citi.ets.publisher.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.ets.publisher.common.ProcessInstance;
import com.citi.ets.publisher.dao.RtviewEtsAlertsDao;
import com.citi.ets.publisher.domain.AlertsView;
import com.citi.ets.publisher.service.BatchProcessor;


/**
 * @author gk85985
 *
 */
@Service("batchProcessor")
public class BatchProcessorImpl implements BatchProcessor{
	
	private Logger log = Logger.getLogger(BatchProcessorImpl.class);
	@Autowired	
	private RtviewEtsAlertsDao alertsDao;

	/**
	 * @usage Fetch records
	 * @return ArrayList<AlertsView>
	 */
	public ArrayList<AlertsView> process() throws Exception {
		log.info("Last successfully processed time = " + ProcessInstance.getTimeLastProcessed());		
		ArrayList<AlertsView> tmpList = new ArrayList<AlertsView>();
		boolean next = true;
		if (ProcessInstance.getTimeLastProcessed() == null) {
			next = false;
			Timestamp mintime = alertsDao.getMinTimeOfAll();
			if (mintime != null) {
				log.debug("Minimum Time of all = "+mintime);
				tmpList = (ArrayList<AlertsView>) alertsDao.getNextRecord(mintime, next);
			}			
		} else {
			tmpList = (ArrayList<AlertsView>) alertsDao.getNextRecord(ProcessInstance.getTimeLastProcessed(), next);
		}
		if (tmpList.isEmpty()) {
			log.info("No next record(s) found, waiting for next poll.");
			return null;
		}
		log.info("Total record(s) to process = "+ tmpList.size());
		return tmpList;		
	}

}
