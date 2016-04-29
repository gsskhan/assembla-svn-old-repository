package org.dms.web.repository;

import java.io.Serializable;

import org.dms.web.document.PaperStatus;
import org.dms.web.document.PaperStores;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaperStatusRepository extends MongoRepository<PaperStatus, Serializable>{
	
	PaperStatus	findOneByPaperStores(PaperStores paperStores);

}
