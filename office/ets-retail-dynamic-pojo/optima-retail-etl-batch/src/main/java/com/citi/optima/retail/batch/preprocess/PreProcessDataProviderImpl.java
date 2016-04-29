/**
 * 
 */
package com.citi.optima.retail.batch.preprocess;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.ReflectionUtils;

import com.citi.retail.optima.etl.batch.dao.PreprocessDatasource;
import com.citi.retail.optima.etl.common.model.FicoRecord;
import com.citi.retail.optima.etl.context.expression.KeyResolverUtil;

public class PreProcessDataProviderImpl<T> implements
	PreProcessorDataProvider<T>{

	private Map<String, Object> preprocessMap;
	private PreprocessDatasource<T> dataSource;
	private List<String> keyAttribute;
	
	public void setKeyAttribute(List<String> keyAttribute) {
		this.keyAttribute = keyAttribute;
	}

	public void setDataSource(PreprocessDatasource<T> dataSource) {
		this.dataSource = dataSource;
	}
	
	public void init() throws Exception{
		if(dataSource!= null){
			getDataFromDataSource();
		}
	}
	@Override
	public void setPreprocessMap(Map<String, Object> preprocessMap) {
		this.preprocessMap = preprocessMap;
		
	}

	@Override
	public Object getValue(String key) {
		return preprocessMap.get(key);
	}
	
	@Override
	public Boolean contains(String key) {
		return preprocessMap.containsKey(key);
	}

	@Override
	public Map<String, Object> getPreprocessMap() {
		return preprocessMap;
	}
	
	private void getDataFromDataSource() throws Exception {
		List<T> dataList = dataSource.getData();
		Object[] keyString = new Object[keyAttribute.size()];
		
		for(T data:dataList){
			int i = 0;
			for(String key : keyAttribute){
				Field fieldKey = data.getClass().getDeclaredField(key);
				fieldKey.setAccessible(true);
				keyString[i] = ReflectionUtils.getField(fieldKey,data);
				i++;
		}
		preprocessMap.put(KeyResolverUtil.keyCreator(keyString), data);
			
		}
		
	}
}
