package com.citi.retail.optima.etl.cache.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.StringUtils;

import com.citi.retail.optima.etl.common.db.dao.ConstraintMapping;
import com.citi.retail.optima.etl.common.db.dao.RuleInfo;

/**
 * Creates a list of Validation Rules, which then is converted into BVal
 * Validation XML. Is used by CacheValidationFactoryBean class.
 */
public class ConstraintMappingResultSetExtractor implements
		ResultSetExtractor<List<ConstraintMapping>> {

	private final List<ConstraintMapping> constraintList;

	public ConstraintMappingResultSetExtractor() {
		constraintList = new ArrayList<ConstraintMapping>();
	}

	@Override
	public List<ConstraintMapping> extractData(ResultSet rs)
			throws SQLException {
		while (rs.next()) {
			Integer processingUnitId = rs.getInt("PROC_UNIT_ID");
			String className = trimSpace(rs.getString("clas_nm"));
			String fieldName = trimSpace(rs.getString("attr_nm"));
			String validationType = trimSpace(rs.getString("vld_typ"));
			String paramName = rs.getString("params_name");
			String paramValue = rs.getString("params_value");
			String constraintClass = trimSpace(rs.getString("vld_clas"));
			String validationCategory = trimSpace(rs.getString("cat_cd"));
			String rulesKey = trimSpace(rs.getString("KEY"));
			Integer ruleId = rs.getInt("VLD_RULE_ID");
			String ruleName = trimSpace(rs.getString("VLD_RULE_NM"));
			Integer ruleExecOrder = rs.getInt("VLD_RULE_EXEC_ORD");

			ConstraintMapping tempMapping = new ConstraintMapping(fieldName,
					validationType, processingUnitId, validationCategory,rulesKey);
			if (!constraintList.contains(tempMapping)) {
				tempMapping.setRules(new ArrayList<RuleInfo>());
				tempMapping.setClassName(className);
				tempMapping.setProcessingUnitId(processingUnitId);
				tempMapping.setValidationCategory(validationCategory);
				constraintList.add(tempMapping);
			}
			ConstraintMapping mapping = constraintList.get(constraintList
					.indexOf(tempMapping));
			RuleInfo rule = null;
			if ((null == paramName) && (null == paramValue)) {
				rule = new RuleInfo(ruleName, ruleId, ruleExecOrder,
						constraintClass);
			} else {
				rule = new RuleInfo(ruleName, ruleId, ruleExecOrder,
						constraintClass, paramName, paramValue);
			}
			if (!mapping.getRules().contains(rule)) {
				mapping.getRules().add(rule);
			}
		}
		return constraintList;
	}

	private String trimSpace(String input) {
		return (input == null) ? null : StringUtils.trimWhitespace(input);
	}

}
