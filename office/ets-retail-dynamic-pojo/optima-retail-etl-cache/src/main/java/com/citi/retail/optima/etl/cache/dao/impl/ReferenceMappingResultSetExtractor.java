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

import com.citi.retail.optima.etl.common.model.cache.ReferenceBandMappingVo;
import com.citi.retail.optima.etl.common.model.cache.ReferenceBandRef;

/**
 * @author TJ
 * 
 */
public class ReferenceMappingResultSetExtractor implements
		ResultSetExtractor<List<ReferenceBandMappingVo>> {

	@Override
	public List<ReferenceBandMappingVo> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		// Todo Change the below mock to actual resultSet retreival

		return mockRefernceList();
	}

	public static List<ReferenceBandMappingVo> mockRefernceList() {

		List<ReferenceBandMappingVo> referenceList = new ArrayList<ReferenceBandMappingVo>();

		ReferenceBandMappingVo referenceVo;

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(10);
		referenceVo.setOutputBandType("FED");
		referenceVo.setRefBandId(1);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(10);
		referenceVo.setOutputBandType("FED");
		referenceVo.setRefBandId(2);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(11);
		referenceVo.setOutputBandType("FED");
		referenceVo.setRefBandId(3);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(12);
		referenceVo.setOutputBandType("FED");
		referenceVo.setRefBandId(4);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(13);
		referenceVo.setOutputBandType("FED");
		referenceVo.setRefBandId(5);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(14);
		referenceVo.setOutputBandType("FED");
		referenceVo.setRefBandId(6);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(14);
		referenceVo.setOutputBandType("FED");
		referenceVo.setRefBandId(7);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(14);
		referenceVo.setOutputBandType("FED");
		referenceVo.setRefBandId(8);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(14);
		referenceVo.setOutputBandType("FED");
		referenceVo.setRefBandId(9);
		referenceList.add(referenceVo);

		// Added for PEARL DLQ
		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(15);
		referenceVo.setOutputBandType("PEARL");
		referenceVo.setRefBandId(1);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(15);
		referenceVo.setOutputBandType("PEARL");
		referenceVo.setRefBandId(2);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(16);
		referenceVo.setOutputBandType("PEARL");
		referenceVo.setRefBandId(3);
		referenceList.add(referenceVo);
		
		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(16);
		referenceVo.setOutputBandType("PEARL");
		referenceVo.setRefBandId(4);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(17);
		referenceVo.setOutputBandType("PEARL");
		referenceVo.setRefBandId(5);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(17);
		referenceVo.setOutputBandType("PEARL");
		referenceVo.setRefBandId(6);
		referenceList.add(referenceVo);
		
		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(17);
		referenceVo.setOutputBandType("PEARL");
		referenceVo.setRefBandId(7);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(17);
		referenceVo.setOutputBandType("PEARL");
		referenceVo.setRefBandId(8);
		referenceList.add(referenceVo);
		
		referenceVo = new ReferenceBandMappingVo();
		referenceVo.setBandId(17);
		referenceVo.setOutputBandType("PEARL");
		referenceVo.setRefBandId(9);
		referenceList.add(referenceVo);
		return referenceList;
	}

}
