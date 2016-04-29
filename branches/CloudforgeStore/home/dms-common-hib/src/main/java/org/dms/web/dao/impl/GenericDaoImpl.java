package org.dms.web.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.dms.web.dao.GenericDao;
import org.dms.web.exception.DmsRuntimeException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.dms.web.mapper.CustomRowMapper;

/**
 * 
 * @author G S S KHAN
 * Generic Dao methods using Hibernate , JdbcTemplate & NamedParameterJdbcTemplate.
 */
public class GenericDaoImpl implements GenericDao{
	
	private SessionFactory sessionFactory;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public Serializable saveEntity(Object entity) throws DmsRuntimeException {
		Session session = getSessionFactory().getCurrentSession();
		return session.save(entity);
	}

	@Override
	public boolean updateEntity(Object entity) throws DmsRuntimeException {
		Session session = getSessionFactory().getCurrentSession();
		session.update(entity);
		session.flush();
		return true;
	}
	

	@Override
	public void saveOrUpdateEntity(Object entity) throws DmsRuntimeException {
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(entity);
		session.flush();
	}	
	

	@Override
	public int delete(String hql, Map<String, ?> paramMap) throws DmsRuntimeException {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		if (paramMap != null && !paramMap.isEmpty()) {
			query.setProperties(paramMap);
		}
		return query.executeUpdate();		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getList(String hql, Map<String, ?> paramMap, int maxrows) throws DmsRuntimeException {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(maxrows);
		if (paramMap != null && !paramMap.isEmpty()) {
			query.setProperties(paramMap);
		}		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getEntity(String hql, Map<String, ?> paramMap) throws DmsRuntimeException {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(10);
		if (paramMap != null && !paramMap.isEmpty()) {
			query.setProperties(paramMap);
		}
		List<T> tmpList = query.list();
		session.flush();
		return (tmpList != null && !tmpList.isEmpty()) ? tmpList.get(0) : null ;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getListWhereEq(Class<T> entityClass, Map<String, ?> paramMap, int maxrows) throws DmsRuntimeException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(entityClass);
		if (paramMap != null && !paramMap.isEmpty()) {
			criteria.add(Restrictions.allEq(paramMap));
		} 
		criteria.setMaxResults(maxrows);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getEntityWhereEq(Class<T> entityClass, Map<String, ?> paramMap) throws DmsRuntimeException {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(entityClass);
		if (paramMap != null && !paramMap.isEmpty()) {
			criteria.add(Restrictions.allEq(paramMap));
		} 
		criteria.setMaxResults(10);
		List<T> tmpList = criteria.list();
		session.flush();
		return (tmpList != null && !tmpList.isEmpty()) ? tmpList.get(0) : null ;
	}
	
	/**
	 * JDBC method to get records using SQL
	 */
	@Override
	public <T> T getObject(String sql, Object[] params , Class<T> requiredType) throws DmsRuntimeException {
		return jdbcTemplate.queryForObject(sql, params, requiredType);
	}
	
	/**
	 * JDBC method to get records using SQL
	 */
	@Override
	public List<Map<String,?>> getList(String sql, Object[] params ) throws DmsRuntimeException {
		return jdbcTemplate.query(sql, params, new CustomRowMapper());
	}

	/**
	 * JDBC method to get records using SQL
	 */
	@Override
	public <T> List<T> getList(String sql, Object[] params , RowMapper<T> rowmapper) throws DmsRuntimeException {
		return jdbcTemplate.query(sql, params, rowmapper);
	}

	/**
	 * JDBC method to get a record using named parameter SQL
	 */
	@Override
	public <T> T getObjectWithNamedParamSql(String namedParamJdbcSql, Map<String, ?> paramMap, Class<T> requiredType) throws DmsRuntimeException {
		return namedParameterJdbcTemplate.queryForObject(namedParamJdbcSql, paramMap, requiredType);
	}

	/**
	 * JDBC method to get records using named parameter SQL
	 */
	@Override
	public List<Map<String, ?>> getListWithNamedParamSql(String namedParamJdbcSql, Map<String, ?> paramMap) throws DmsRuntimeException {
		return 	namedParameterJdbcTemplate.query(namedParamJdbcSql, paramMap, new CustomRowMapper());	
	}
	
	/**
	 * JDBC method to get records using named parameter SQL
	 */
	@Override
	public <T> List<T> getListWithNamedParamSql(String namedParamJdbcSql, Map<String, ?> paramMap, RowMapper<T> rowMapper ) throws DmsRuntimeException {
		return 	namedParameterJdbcTemplate.query(namedParamJdbcSql, paramMap, rowMapper);		
	}

	
	// getter-setter methods
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

}
