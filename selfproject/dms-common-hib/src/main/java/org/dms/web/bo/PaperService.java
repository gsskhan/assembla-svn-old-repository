package org.dms.web.bo;

import java.util.List;

import org.dms.web.entity.PaperStore;
import org.dms.web.exception.DmsException;



public interface PaperService {
	
	String addNewPaperToStore(String paperTitle, String filename, byte[] uploadedData, String uploaderName
			, boolean assignForauthorization, String assignedAuthorizerName) throws DmsException;
	
	List<String> getAuthorizerListWhenCreatorIs(String creatorName) throws DmsException;
	
	PaperStore getPaper(String paperTitle, String paperNumber) throws DmsException;

}
