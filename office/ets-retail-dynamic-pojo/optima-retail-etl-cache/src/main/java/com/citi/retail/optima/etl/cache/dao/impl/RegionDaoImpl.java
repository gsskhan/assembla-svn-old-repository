package com.citi.retail.optima.etl.cache.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.qos.logback.classic.Logger;

import com.citi.retail.optima.etl.cache.dao.CacheLoaderDao;
import com.citi.retail.optima.etl.cache.model.CountryRegionMappingVO;
import com.citi.retail.optima.etl.cache.model.CountryRegionVO;
import com.citi.retail.optima.etl.cache.model.RegionUserSegVO;
import com.citi.retail.optima.etl.cache.model.RegionVO;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;

/**
 * 
 * @author mc56120
 *
 */
public class RegionDaoImpl implements InitializingBean,
		CacheLoaderDao<CountryRegionVO>  {

	private List<CountryRegionVO> countryRegionList;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		countryRegionList = getData();
	}

	public List<CountryRegionVO> getData()
			throws OptimaRetailApplicationException {
		return populateMockData();
	}

	@Override
	public  List<CountryRegionVO> getCacheData(Object... args) throws Exception {
		return countryRegionList;
	}
	
	private List<CountryRegionVO> populateMockData() {
		List<CountryRegionVO> ctryRegionList = new ArrayList<CountryRegionVO>();
		for (int i =1 ; i < 10 ; i ++){
			CountryRegionVO ctryRegion = new CountryRegionVO();
			RegionVO region = new RegionVO();
			RegionUserSegVO regionUserSegVO = new RegionUserSegVO();
			CountryRegionMappingVO countryRegionMapping = new CountryRegionMappingVO();
			int pUnit=5;
			region.setGeographyId(i);
			region.setRegionName("LATAM" +i);
			region.setRegionDescr("Region Description" +i);
			region.setProcessingUnitId(pUnit);
			//if(i%2==0){
			if(i<5){
				region.setSegmentType("CITI");
				region.setRegionIntCode(i);
			}
			else{
				region.setSegmentType("FED");
				region.setRegionStrCode("0" +(i-5));
			}
			if(i<5){
				regionUserSegVO.setGeographyId(i);
				regionUserSegVO.setOutputSegType("FED");
				regionUserSegVO.setGeographyRefId(i+5);
			}else{
				regionUserSegVO.setGeographyId(i);
				regionUserSegVO.setOutputSegType("CITI");
			}
			
			//Country - Region User Segment
			countryRegionMapping.setCountryCode("C" +i);
			countryRegionMapping.setProcessingUnitId(pUnit);			
			if(i<5){
				countryRegionMapping.setSegmentType("CITI");
				countryRegionMapping.setRefGeographyId(i);
			}else{
				countryRegionMapping.setSegmentType("FED");
				countryRegionMapping.setRefGeographyId(i);
			}
			ctryRegion.setRegionVO(region);
			ctryRegion.setRegionUserSegVO(regionUserSegVO);
			ctryRegion.setCountryRegionMapping(countryRegionMapping);
			ctryRegionList.add(ctryRegion);
		}
		return ctryRegionList;
	}
	
}
