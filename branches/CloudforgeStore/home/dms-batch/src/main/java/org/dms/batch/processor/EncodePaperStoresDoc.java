package org.dms.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.dms.web.document.PaperStores;
import org.springframework.batch.item.ItemProcessor;

public class EncodePaperStoresDoc implements ItemProcessor<PaperStores, List<?>>{

	@Override
	public List<?> process(PaperStores paperStores) throws Exception {
		List<Object> tmpList = new ArrayList<Object>();
		tmpList.add(paperStores.getId());
		tmpList.add(paperStores.getNumber());
		tmpList.add(paperStores.getTitle());
		tmpList.add(Base64.encodeBase64String(paperStores.getData()));
		tmpList.add(paperStores.getOriginalFilename());
		tmpList.add(paperStores.getCreatedByUser().getId());
		tmpList.add(paperStores.getCreationTime());
		return tmpList;
	}

}
