/**
 * 
 */
package com.citi.retail.optima.etl.aggregation.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.aggregation.dao.AggregationDao;

import com.citi.retail.optima.etl.aggregation.model.AggregationDAOHelper;
import com.citi.retail.optima.etl.aggregation.model.AggregationVO;

/**
 * @author mc56120 DAO to save aggregation results to DB
 * 
 */

public class AggregationDaoImpl implements AggregationDao {

	private static final String REGEX = ";;;";
	private  final Pattern splitingPattern = Pattern.compile(REGEX);
	private static final Logger LOGGER = (Logger) LoggerFactory
			.getLogger(AggregationDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	/**
	 * Save aggregation results to DB
	 */
	@Override
	public boolean saveAggregationResults(List<AggregationVO> aggregationVO) {
		boolean savedSuccessfully = true;
		List<AggregationDAOHelper> aggregationHelperList = null;
		boolean insertStatus[] = new boolean[aggregationVO.size()];
		AggregationDAOHelper aggregationHelper = null;
		int i = 0;
		for (AggregationVO aggrVO : aggregationVO) {
			Map<String, List<Number>> aggregationValuesMap = aggrVO
					.getAggregationValues();
			String sql = aggrVO.getInsertSql();
			aggregationHelperList = new ArrayList<AggregationDAOHelper>();

			for (String aggrKeyStr : aggregationValuesMap.keySet()) {
				List<String> keyList = getSplitKeys(aggrKeyStr);
				aggregationHelper = new AggregationDAOHelper(keyList,
						aggregationValuesMap.get(aggrKeyStr));
				aggregationHelperList.add(aggregationHelper);
			}
			insertStatus[i] = batchInsertAggregation(aggrVO,
					aggregationHelperList, sql);
			i++;
		}

		for (boolean results : insertStatus) {
			if (!results) {
				savedSuccessfully = false;
				break;
			}
		}
		return savedSuccessfully;
	}

	/**
	 * 
	 * @param aggrVO
	 * @param aggregationHelperList
	 * @param sql
	 * @return
	 */
	private boolean batchInsertAggregation(final AggregationVO aggrVO,
			final List<AggregationDAOHelper> aggregationHelperList, String sql) {
		int results[] = jdbcTemplate.batchUpdate(sql,
				new BatchPreparedStatementSetter(){
			
					@Override
					public void setValues(PreparedStatement ps, int arg1)  throws SQLException{
							setAggrValues(aggrVO, aggregationHelperList, ps, arg1);
					}

					@Override
					public int getBatchSize() {
						return aggregationHelperList.size();
					}
				}) ;
		LOGGER.info("***Aggregation bucket size == " + results.length);
		return aggregationHelperList.size() == results.length ? true : false;
	}

	private List<String> getSplitKeys(String aggrKey) {
		List<String> result = new ArrayList<String>();
		String splitValues[] = splitingPattern.split(aggrKey);
		result = Arrays.asList(splitValues);
		return result;
	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate
	 *            the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param aggrVO
	 * @param aggregationHelperList
	 * @param ps
	 * @param arg1
	 */
	private void setAggrValues(final AggregationVO aggrVO,
			final List<AggregationDAOHelper> aggregationHelperList,
			PreparedStatement ps, int arg1) throws SQLException {

		AggregationDAOHelper aggregationHelper = aggregationHelperList
				.get(arg1);
		int i = 0;

			ps.setLong(++i, aggrVO.getJobInstanceId());

			ps.setInt(++i, Integer.valueOf(aggrVO.getAggregationType()));
			ps.setInt(++i, aggrVO.getSysProcId());
			for (String key : aggregationHelper.getAggregationKey()) {
				ps.setObject(++i, key);
			}
			for (Number key : aggregationHelper.getAggregationValues()) {
				if (key == null) {
					key = 0;
				}
				ps.setDouble(++i, key.doubleValue());
			}
			
		
	}

}
