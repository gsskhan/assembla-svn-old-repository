package com.citi.risk.dashboard.dao;

import java.util.List;
import org.hibernate.HibernateException;
import com.citi.risk.dashboard.entity.Organisation;

/**
 * @author gk85985
 * 
 */
public interface OrganisationDao {

    List<Organisation> getOrgDetails(long orgId) throws HibernateException;
}
