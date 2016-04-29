/**
 * 
 */
package com.citi.retail.optima.etl.cache.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.citi.retail.optima.etl.cache.model.BaseRef;

/**
 * @author TJ
 * 
 */
public class ReferenceBandResultSetExtractor implements
		ResultSetExtractor<Set<Entry<BaseRef, Map<Integer, String>>>> {

	@Override
	public Set<Entry<BaseRef, Map<Integer, String>>> extractData(ResultSet rs)
			throws SQLException {

		Map<BaseRef, Map<Integer, String>> baseRefMap = new HashMap<BaseRef, Map<Integer, String>>();
		BaseRef baseRef;

		while (rs.next()) {
			baseRef = new BaseRef();
			baseRef.setProcessingUnitId(rs.getInt("PROC_UNIT_ID"));

			if (baseRefMap.containsKey(baseRef)) {
				Map<Integer, String> tempMap = baseRefMap.get(baseRef);
				tempMap.put(rs.getInt("UPPER_BAND"), rs.getString("SEG_VAL")
						.trim());
			} else {
				Map<Integer, String> tempMap = new TreeMap<Integer, String>();
				tempMap.put(rs.getInt("UPPER_BAND"), rs.getString("SEG_VAL")
						.trim());
				baseRefMap.put(baseRef, tempMap);
			}
		}
		return baseRefMap.entrySet();
	}

}
