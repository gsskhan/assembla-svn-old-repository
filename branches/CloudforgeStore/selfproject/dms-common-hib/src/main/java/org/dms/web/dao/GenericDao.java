package org.dms.web.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.dms.web.exception.DmsRuntimeException;
import org.springframework.jdbc.core.RowMapper;

public interface GenericDao {
	
	// Hibernate methods
	public Serializable saveEntity(Object entity) throws DmsRuntimeException;
	public boolean updateEntity(Object entity) throws DmsRuntimeException;
	public void saveOrUpdateEntity(Object entity) throws DmsRuntimeException;
	public int delete(String deleteHql, Map<String, ?> paramMap ) throws DmsRuntimeException;
	
	public <T> List<T> getList(String hql, Map<String, ?> paramMap, int maxrows) throws DmsRuntimeException;
	public <T> T getEntity(String hql, Map<String, ?> paramMap) throws DmsRuntimeException;
	
	public <T> List<T> getListWhereEq(Class<T> entityClass, Map<String, ?> paramMap, int maxrows) throws DmsRuntimeException;
	public <T> T getEntityWhereEq(Class<T> entityClass, Map<String, ?> paramMap) throws DmsRuntimeException;
	
	// Jdbc methods
	public <T> T getObject(String sql, Object[] params , Class<T> requiredType) throws DmsRuntimeException;
	public List<Map<String, ?>> getList(String sql, Object[] params ) throws DmsRuntimeException;
	public <T> List<T> getList(String sql, Object[] params , RowMapper<T> rowmapper) throws DmsRuntimeException;
	
	// Jdbc Named Param methods
	public <T> T getObjectWithNamedParamSql(String namedParamJdbcSql, Map<String, ?> paramMap , Class<T> requiredType) throws DmsRuntimeException;
	public List<Map<String, ?>> getListWithNamedParamSql(String namedParamJdbcSql, Map<String, ?> paramMap ) throws DmsRuntimeException;
	public <T> List<T> getListWithNamedParamSql(String namedParamJdbcSql, Map<String, ?> paramMap, RowMapper<T> rowMapper ) throws DmsRuntimeException;
	
}
