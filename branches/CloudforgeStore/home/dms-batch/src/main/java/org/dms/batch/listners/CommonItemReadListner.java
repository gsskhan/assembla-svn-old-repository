package org.dms.batch.listners;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ItemReadListener;

public class CommonItemReadListner implements ItemReadListener<Object>{
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public void afterRead(Object item) {
		log.info("finished: reading -"+ item);		
	}

	@Override
	public void beforeRead() {
		log.debug("starting: reading.");		
	}

	@Override
	public void onReadError(Exception e) {
		log.error("error reading. error details :-", e);		
	}

}
