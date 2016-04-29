package org.dms.batch.listners;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ItemWriteListener;

public class CommonItemWriterListner<S> implements ItemWriteListener<S> {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public void afterWrite(List<? extends S> list) {
		log.info("finished: total rows written = "+ list.size() );
	}

	@Override
	public void beforeWrite(List<? extends S> list) {
		log.info("starting: total rows to write = "+ list.size() );		
	}

	@Override
	public void onWriteError(Exception e, List<? extends S> list) {
		log.error("error: total rows to write = "+ list.size(), e);		
	}

}
