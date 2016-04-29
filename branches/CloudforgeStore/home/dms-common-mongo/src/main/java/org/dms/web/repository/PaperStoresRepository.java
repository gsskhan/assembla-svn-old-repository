package org.dms.web.repository;

import java.io.Serializable;

import org.dms.web.document.PaperStores;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaperStoresRepository extends MongoRepository<PaperStores, Serializable> {
	
	PaperStores findOneByNumber(long number);

}
