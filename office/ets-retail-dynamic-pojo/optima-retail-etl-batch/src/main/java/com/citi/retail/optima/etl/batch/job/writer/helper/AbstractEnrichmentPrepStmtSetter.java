/**
 * 
 */
package com.citi.retail.optima.etl.batch.job.writer.helper;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Map.Entry;

import oracle.jdbc.OraclePreparedStatement;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

/**
 * @author TJ This is an abstract class with Utility methods for persisting
 *         Enrichment results.
 */
public abstract class AbstractEnrichmentPrepStmtSetter<T> implements
		ItemPreparedStatementSetter<T> {

	protected DateFormat df = new SimpleDateFormat("MMyyyy");

	/**
	 * 
	 * @param ps
	 * @param param
	 * @param paramIdx
	 * @throws SQLException
	 */
	protected void setObject(PreparedStatement ps, int paramIdx, Object param)
			throws SQLException {
		if (param != null) {
			ps.setObject(paramIdx, param);
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param ps
	 * @param paramIdx
	 * @throws SQLException
	 */
	protected void setNull(PreparedStatement ps, int paramIdx)
			throws SQLException {
		ps.setNull(paramIdx, Types.NULL);
	}

	/**
	 * 
	 * @param ps
	 * @param param
	 * @param paramIdx
	 * @throws SQLException
	 */
	protected void setString(PreparedStatement ps, int paramIdx, String param)
			throws SQLException {
		if (param != null) {
			ps.setString(paramIdx, param);
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param ps
	 * @param paramIdx
	 * @param param
	 * @throws SQLException
	 */
	protected void setBoolean(PreparedStatement ps, int paramIdx, Boolean param)
			throws SQLException {
		if (param != null) {
			ps.setBoolean(paramIdx, param);
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param ps
	 * @param param
	 * @param paramIdx
	 * @throws SQLException
	 */
	protected void setInt(PreparedStatement ps, int paramIdx, Integer param)
			throws SQLException {
		if (param != null) {
			ps.setInt(paramIdx, param);
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param ps
	 * @param param
	 * @param paramIdx
	 * @throws SQLException
	 */
	protected void setLong(PreparedStatement ps, int paramIdx, Long param)
			throws SQLException {
		if (param != null) {
			ps.setLong(paramIdx, param);
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param ps
	 * @param param
	 * @param paramIdx
	 * @throws SQLException
	 */
	protected void setDouble(PreparedStatement ps, int paramIdx, Double param)
			throws SQLException {
		if (param != null) {
			ps.setDouble(paramIdx, param);
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param ps
	 * @param param
	 * @param paramIdx
	 * @throws SQLException
	 */
	protected void setBigDecimal(PreparedStatement ps, int paramIdx,
			BigDecimal param) throws SQLException {
		if (param != null) {
			ps.setBigDecimal(paramIdx, param);
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param ps
	 * @param param
	 * @param paramIdx
	 * @throws SQLException
	 */
	protected void setDate(PreparedStatement ps, int paramIdx, Date param)
			throws SQLException {
		if (param != null) {
			ps.setDate(paramIdx, param);
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param ps
	 * @param paramIdx
	 * @param param
	 * @throws SQLException
	 */
	protected void setStringForDate(PreparedStatement ps, int paramIdx, java.util.Date param)
			throws SQLException {
		if (param != null) {
			setString(ps, paramIdx, df.format(param));
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param ps
	 * @param param
	 * @param paramIdx
	 * @throws SQLException
	 */
	protected void setStringForClob(PreparedStatement ps, int paramIdx,
			String param) throws SQLException {
		if (param != null) {
			((OraclePreparedStatement) ps).setStringForClob(paramIdx, param);
		} else {
			setNull(ps, paramIdx);
		}
	}

	/**
	 * 
	 * @param booleanMap
	 * @return
	 */
	protected String convertBooleanMapToJson(Map<String, Boolean> booleanMap) {
		if (booleanMap == null) {
			return null;
		}
		StringBuilder jsonString = new StringBuilder();
		jsonString.append("{");
		for (Entry<String, Boolean> entry : booleanMap.entrySet()) {
			if (jsonString.length() > 1) {
				jsonString.append(" , ");
			}
			jsonString.append("\"").append(entry.getKey()).append("\"")
					.append(" : ").append("\"").append(entry.getValue())
					.append("\"");
		}
		jsonString.append("}");
		return jsonString.toString();
	}

}
