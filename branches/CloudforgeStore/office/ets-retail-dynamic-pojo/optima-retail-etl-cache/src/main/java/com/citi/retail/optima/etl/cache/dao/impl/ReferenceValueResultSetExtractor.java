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

import org.springframework.jdbc.core.ResultSetExtractor;

import com.citi.retail.optima.etl.cache.model.BaseRef;

/**
 * @author TJ
 * 
 */
public class ReferenceValueResultSetExtractor implements
		ResultSetExtractor<Set<Entry<BaseRef, Map<String, String>>>> {

	@Override
	public Set<Entry<BaseRef, Map<String, String>>> extractData(ResultSet rs)
			throws SQLException {

		Map<BaseRef, Map<String, String>> baseRefMap = new HashMap<BaseRef, Map<String, String>>();
		BaseRef baseRef;

		while (rs.next()) {
			baseRef = new BaseRef();
			baseRef.setProcessingUnitId(rs.getInt("PROC_UNIT_ID"));

			if (baseRefMap.containsKey(baseRef)) {
				Map<String, String> tempMap = baseRefMap.get(baseRef);
				tempMap.put(rs.getString("KEY"), rs.getString("SEG_VAL").trim());
			} else {
				Map<String, String> tempMap = new HashMap<String, String>();
				tempMap.put(rs.getString("KEY"), rs.getString("SEG_VAL").trim());
				baseRefMap.put(baseRef, tempMap);
			}
		}
		return baseRefMap.entrySet();
	}

}
