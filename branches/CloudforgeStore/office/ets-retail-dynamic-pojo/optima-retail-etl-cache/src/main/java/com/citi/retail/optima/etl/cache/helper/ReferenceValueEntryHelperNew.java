package com.citi.retail.optima.etl.cache.helper;

import java.util.Map;
import java.util.Map.Entry;

import com.citi.retail.optima.etl.cache.model.ReferenceValueRef;
import com.citi.retail.optima.etl.common.model.cache.KeyRef;

/**
 * @author sr67841
 * 
 */
public class ReferenceValueEntryHelperNew
		implements
		CacheEntryHelper<Entry<KeyRef, Map<String, ReferenceValueRef>>, KeyRef, Map<String, ReferenceValueRef>> {

	@Override
	public KeyRef getKey(Entry<KeyRef, Map<String, ReferenceValueRef>> entity) {
		return entity.getKey();
	}

	@Override
	public Map<String, ReferenceValueRef> getValue(
			Entry<KeyRef, Map<String, ReferenceValueRef>> entity) {
		return entity.getValue();
	}

}
