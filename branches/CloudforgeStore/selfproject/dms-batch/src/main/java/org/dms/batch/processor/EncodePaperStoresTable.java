package org.dms.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.batch.item.ItemProcessor;

public class EncodePaperStoresTable implements ItemProcessor<Object[], List<?>>{

	@Override
	public List<?> process(Object[] obj) throws Exception {
		List<Object> tmpList = new ArrayList<Object>();
		tmpList.add(obj[0]);
		tmpList.add(obj[1]);
		tmpList.add(obj[2]);
		tmpList.add(Base64.encodeBase64String((byte[]) obj[3]));
		tmpList.add(obj[4]);
		tmpList.add(obj[5]);
		return tmpList;
	}

}
