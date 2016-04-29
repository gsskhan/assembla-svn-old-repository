/**
 * 
 */
package com.citi.retail.optima.etl.batch.job.writer.fieldextractor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
//import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author av51190
 *
 */
public class RRASCustomFieldExtractor<T> implements InitializingBean,
		FieldExtractor<T> {
	private String[] names;
	
	public void setNames(String[] names) {
		this.names = names;
	}

	private Map<String, String> formatMap;
	
	public void setFormatMap(final Map<String, String> formatMap) {
		this.formatMap = formatMap;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] extract(T item) {
		final List<Object> values = new ArrayList<Object>();

        final BeanWrapper bw = new BeanWrapperImpl(item);
        for (final String propertyName : this.names) {
            Object propertyValue = bw.getPropertyValue(propertyName);
            if (propertyValue != null) {
                final String myFormat = formatMap!=null?formatMap.get(propertyName):null;
                // Do we have a format
                if (myFormat != null) {
                    // only format Date and Calendar Objects
                    if (propertyValue instanceof Date) {
                        propertyValue = DateFormatUtils.format((Date) propertyValue, myFormat);
                    } else if (propertyValue instanceof Calendar) {
                        propertyValue = DateFormatUtils.format(((Calendar) propertyValue).getTime(), myFormat);
                    }
                }
            }
            values.add(propertyValue);
        }
        return values.toArray();
	}
	

}
