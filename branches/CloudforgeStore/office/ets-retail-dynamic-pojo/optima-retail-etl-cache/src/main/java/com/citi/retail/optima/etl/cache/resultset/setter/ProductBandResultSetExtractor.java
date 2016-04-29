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

import com.citi.retail.optima.etl.common.model.cache.ProductBandDomain;

/**
 * 
 * @author mc56120
 *
 */
public class ProductBandResultSetExtractor implements
		ResultSetExtractor<List<ProductBandDomain>> {

	@Override
	public List<ProductBandDomain> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<ProductBandDomain> referenceList = new ArrayList<ProductBandDomain>();
		ProductBandDomain productBand = null;
		
		while (rs.next()){
			productBand = new ProductBandDomain();
			productBand.setProductTypeCd(rs.getString("prod_typ_cd"));
			productBand.setProcessingUnitId(rs.getInt("pu"));
			productBand.setProductTypeSegVal(rs.getString("prod_typ_seg_val"));
			productBand.setProductTypeSegDesc(rs.getString("prod_type_seg_desc"));
			productBand.setAccLvlproductTypeCd(rs.getString("acc_lvl_prod_cd")); 
			productBand.setProductBandId(rs.getLong("band_id")); 
			productBand.setSegmentType(rs.getString("lvl_type"));
			referenceList.add(productBand);	
		}
		return referenceList;
	}

}
