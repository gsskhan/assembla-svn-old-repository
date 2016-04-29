package org.dms.batch.processor;

import java.util.ArrayList;
import java.util.List;

import org.dms.web.document.PaperStatus;
import org.springframework.batch.item.ItemProcessor;

public class RemoveNullsPaperStatus implements ItemProcessor<PaperStatus, List<?>>{

	@Override
	public List<?> process(PaperStatus status) throws Exception {
		List<Object> tmpList = new ArrayList<Object>();
		tmpList.add(status.getId());
		if (status.getPaperStores() != null) {
			tmpList.add(status.getPaperStores().getId());
		} else {
			tmpList.add(null);
		}		
		tmpList.add(status.isAuthorized());
		if (status.getAuthorizedBy() != null) {
			tmpList.add(status.getAuthorizedBy().getId());
		} else {
			tmpList.add(null);
		}		
		tmpList.add(status.getAuthorizationTime());
		tmpList.add(status.isApproved());
		if (status.getApprovedBy() != null) {
			tmpList.add(status.getApprovedBy().getId());
		} else {
			tmpList.add(null);
		}
		tmpList.add(status.getApprovalTime());
		tmpList.add(status.isRejected());
		if (status.getRejectedBy() != null) {
			tmpList.add(status.getRejectedBy().getId());
		} else {
			tmpList.add(null);
		}
		tmpList.add(status.getRejectionTime());
		tmpList.add(status.getComments());
		return tmpList;
	}

}
