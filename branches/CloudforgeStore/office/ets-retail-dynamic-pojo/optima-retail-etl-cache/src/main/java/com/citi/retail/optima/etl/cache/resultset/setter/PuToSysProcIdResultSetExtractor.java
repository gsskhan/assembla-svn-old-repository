/**
 * 
 */
package com.citi.retail.optima.etl.cache.resultset.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.citi.retail.optima.etl.cache.model.PuToSysProcIdVO;

/**
 * @author mc56120
 *
 */
public class PuToSysProcIdResultSetExtractor implements
ResultSetExtractor<List<PuToSysProcIdVO>> {

	@Override
	public List<PuToSysProcIdVO> extractData(ResultSet rs) throws SQLException,
	DataAccessException {

		List<PuToSysProcIdVO> resultList = new ArrayList<PuToSysProcIdVO>();
		PuToSysProcIdVO puToSysProcId;

		while(rs.next()){
			puToSysProcId = new PuToSysProcIdVO();
			puToSysProcId.setProcessingUnit(rs.getInt("PROC_UNIT_ID"));
			puToSysProcId.setBatchId(rs.getInt("BATCH_ID"));
			puToSysProcId.setSysProcId(rs.getInt("SYS_PROC_ID"));
			resultList.add(puToSysProcId);
		}
		return resultList;		
	}
}