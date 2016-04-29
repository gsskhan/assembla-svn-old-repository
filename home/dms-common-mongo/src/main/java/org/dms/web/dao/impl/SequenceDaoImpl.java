package org.dms.web.dao.impl;

import org.apache.log4j.Logger;
import org.dms.web.dao.SequenceDao;
import org.dms.web.document.Sequence;
import org.dms.web.exception.DmsRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class SequenceDaoImpl implements SequenceDao{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public long getNextSequenceId(String key){
		//get sequence
		Query query = new Query(Criteria.where("_id").is(key));
		// get old sequence
		Sequence oldseq = mongoTemplate.findOne(query, Sequence.class);
		if (oldseq == null) {
			mongoTemplate.save(new Sequence(key,0));
			log.info("No sequence found for key '"+key+"', created a new sequence record for this key.");
		}
		//increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);
		//return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		// get the sequence 
		Sequence newseq = mongoTemplate.findAndModify(query, update, options, Sequence.class);
		//if no id, throws Exception
        //optional, just a way to tell user when the sequence id is failed to generate.
		if (newseq == null) {
			throw new DmsRuntimeException("Unable to get sequence id for key : " + key);
		}
		return newseq.getSeq();		
	}

}
