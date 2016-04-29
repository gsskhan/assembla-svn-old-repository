package com.citi.risk.dashboard.dao.impl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.citi.risk.dashboard.dao.AppComStatusDao;
import com.citi.risk.dashboard.dao.GenericDao;
import com.citi.risk.dashboard.entity.AppComStatus;

/**
 * 
 * @author gk85985 Dao methods for 'AppComStatus' entity
 */
@Repository("appComStatusDao")
public class AppComStatusDaoImpl implements AppComStatusDao {

    @Autowired
    private GenericDao genericDao;

    public void saveAppComStatus(AppComStatus appComStatus)
            throws HibernateException {
        genericDao.saveEntity(appComStatus);
    }

    // getter-setter methods
    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }
}
