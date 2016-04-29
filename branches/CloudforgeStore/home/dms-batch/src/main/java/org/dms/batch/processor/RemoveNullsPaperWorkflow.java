package org.dms.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.dms.web.document.PaperWorkflow;
import org.springframework.batch.item.ItemProcessor;

public class RemoveNullsPaperWorkflow implements ItemProcessor<PaperWorkflow, List<?>>{

	@Override
	public List<?> process(PaperWorkflow workflow) throws Exception {
		List<Object> tmpList = new ArrayList<Object>();
		tmpList.add(workflow.getId());
		if (workflow.getPaperStores() != null) {
			tmpList.add(workflow.getPaperStores().getId());
		} else{
			tmpList.add(null);
		}	
		if (workflow.getAssignedToUser() != null) {
			tmpList.add(workflow.getAssignedToUser().getId());
		} else{
			tmpList.add(null);
		}	
		tmpList.add(workflow.getAssignedOnTime());
		if (workflow.getCompletedByUser() != null) {
			tmpList.add(workflow.getCompletedByUser().getId());
		} else{
			tmpList.add(null);		
		}		
		tmpList.add(workflow.isCompleted());
		tmpList.add(workflow.getCompletionTime());
		tmpList.add(workflow.getComments());
		return tmpList;
	}

}
