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

import com.citi.retail.optima.etl.common.model.cache.ReferenceBandRef;

/**
 * @author TJ
 * 
 */
public class ReferenceBandResultSetExtractorNew implements
		ResultSetExtractor<List<ReferenceBandRef>> {

	@Override
	public List<ReferenceBandRef> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		// Todo Change the below mock to actual resultSet retreival

		return mockRefernceList();
	}

	public static List<ReferenceBandRef> mockRefernceList() {

		List<ReferenceBandRef> referenceList = new ArrayList<ReferenceBandRef>();
	for(int i=1;i<=8; i++)
		
	{
		ReferenceBandRef referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(1);
		referenceVo.setBandType("Citi");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(0);
		referenceVo.setUpperBand(0);
		referenceVo.setSegCode(1);
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(2);
		referenceVo.setBandType("Citi");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(1);
		referenceVo.setUpperBand(29);
		referenceVo.setSegCode(2);
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(3);
		referenceVo.setBandType("Citi");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(30);
		referenceVo.setUpperBand(59);
		referenceVo.setSegCode(3);
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(4);
		referenceVo.setBandType("Citi");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(60);
		referenceVo.setUpperBand(89);
		referenceVo.setSegCode(4);
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(5);
		referenceVo.setBandType("Citi");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(90);
		referenceVo.setUpperBand(119);
		referenceVo.setSegCode(5);
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(6);
		referenceVo.setBandType("Citi");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(120);
		referenceVo.setUpperBand(149);
		referenceVo.setSegCode(6);
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(7);
		referenceVo.setBandType("Citi");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(150);
		referenceVo.setUpperBand(179);
		referenceVo.setSegCode(7);
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(8);
		referenceVo.setBandType("Citi");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(180);
		referenceVo.setUpperBand(999999);
		referenceVo.setSegCode(8);
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(9);
		referenceVo.setBandType("Citi");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(-1);
		referenceVo.setUpperBand(-1);
		referenceVo.setSegCode(9);
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(10);
		referenceVo.setBandType("Fed");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(0);
		referenceVo.setUpperBand(29);
		referenceVo.setSegVal("01");
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(11);
		referenceVo.setBandType("Fed");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(30);
		referenceVo.setUpperBand(59);
		referenceVo.setSegVal("02");
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(12);
		referenceVo.setBandType("Fed");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(60);
		referenceVo.setUpperBand(89);
		referenceVo.setSegVal("03");
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(13);
		referenceVo.setBandType("Fed");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(90);
		referenceVo.setUpperBand(119);
		referenceVo.setSegVal("04");
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(14);
		referenceVo.setBandType("Fed");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(120);
		referenceVo.setUpperBand(9999999);
		referenceVo.setSegVal("05");
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		// /Added for PEAL DLQ Cache
		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(15);
		referenceVo.setBandType("PEARL");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(0);
		referenceVo.setUpperBand(0);
		referenceVo.setSegVal("-30");
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(16);
		referenceVo.setBandType("PEARL");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(31);
		referenceVo.setUpperBand(90);
		referenceVo.setSegVal("30+");
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);

		referenceVo = new ReferenceBandRef();
		referenceVo.setKeyId(17);
		referenceVo.setBandType("PEARL");
		referenceVo.setBandDesc("some desc");
		referenceVo.setLowerBand(91);
		referenceVo.setUpperBand(9999999);
		referenceVo.setSegVal("90+");
		referenceVo.setProcessingUnitId(i);
		referenceList.add(referenceVo);
	}

		return referenceList;
	}
}
