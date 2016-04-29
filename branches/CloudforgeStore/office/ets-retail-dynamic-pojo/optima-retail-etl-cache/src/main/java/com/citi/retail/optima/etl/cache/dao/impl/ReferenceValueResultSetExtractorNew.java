/**
 * 
 */
package com.citi.retail.optima.etl.cache.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.citi.retail.optima.etl.cache.model.ReferenceValueRef;

/**
 * @author TJ
 * 
 */
public class ReferenceValueResultSetExtractorNew implements
		ResultSetExtractor<List<ReferenceValueRef>> {

	@Override
	public List<ReferenceValueRef> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		// Todo Change the below mock to actual resultSet retreival
		return mockRefernceList();
	}

	public static List<ReferenceValueRef> mockRefernceList() {

		List<ReferenceValueRef> referenceList = new ArrayList<ReferenceValueRef>();

		ReferenceValueRef referenceVo = new ReferenceValueRef();
		referenceVo.setKey("1");
		referenceVo.setValue("1");
		referenceVo.setProcessingUnitId(5);
		referenceVo.setBandType("Citi");
		referenceList.add(referenceVo);

		referenceVo = new ReferenceValueRef();
		referenceVo.setKey("2");
		referenceVo.setValue("2");
		referenceVo.setProcessingUnitId(5);
		referenceVo.setBandType("Citi");
		referenceList.add(referenceVo);

		referenceVo = new ReferenceValueRef();
		referenceVo.setKey("1");
		referenceVo.setValue("01");
		referenceVo.setProcessingUnitId(5);
		referenceVo.setBandType("Fed");
		referenceList.add(referenceVo);
		
		return referenceList;
	}


}
