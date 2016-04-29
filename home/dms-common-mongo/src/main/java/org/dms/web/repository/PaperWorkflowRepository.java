package org.dms.web.repository;

import java.io.Serializable;
import java.util.List;

import org.dms.web.document.PaperStores;
import org.dms.web.document.PaperWorkflow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaperWorkflowRepository extends MongoRepository<PaperWorkflow, Serializable>{
	
	List<PaperWorkflow> findByCompletedIsFalse();
	
	List<PaperWorkflow> findByPaperStores(PaperStores paperStores);

}
