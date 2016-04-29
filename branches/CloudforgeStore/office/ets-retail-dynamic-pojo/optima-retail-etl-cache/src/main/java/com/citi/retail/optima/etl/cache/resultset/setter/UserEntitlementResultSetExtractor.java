package com.citi.retail.optima.etl.cache.resultset.setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.citi.retail.optima.etl.cache.model.EntitlementVO;

public class UserEntitlementResultSetExtractor implements
ResultSetExtractor<List<EntitlementVO>> {

	@Override
	public List<EntitlementVO> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<EntitlementVO> resultList = new ArrayList<EntitlementVO>();
		EntitlementVO user;
		while(rs.next()){
			user = new EntitlementVO();
			user.setSoeId(rs.getString("SOE_ID"));
			user.setBussFuncCd(rs.getString("bus_func_cd"));
			user.setRoleId(rs.getLong("role_id"));
			user.setCmpReqId(rs.getString("cmp_req_id"));
			user.setRegion(rs.getString("region"));
			user.setRgnId(rs.getLong("rgn_id"));
			user.setFrbRegion(rs.getString("frb_region"));
			user.setCountry(rs.getString("country"));
			user.setBusinessUnit(rs.getString("business_unit"));
			user.setEntlProd(rs.getString("entl_prod"));
			user.setSbmnProd(rs.getString("sbmn_prd"));
			user.setFrbSchd(rs.getString("frb_schd"));
			resultList.add(user);
		}
		return resultList;
	}

}
