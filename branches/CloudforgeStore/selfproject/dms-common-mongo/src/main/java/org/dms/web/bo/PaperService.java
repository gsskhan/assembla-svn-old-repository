package org.dms.web.bo;

import java.util.List;
import java.util.Map;

import org.dms.web.exception.DmsException;

public interface PaperService {
	
	String addNewPaperToStore(String paperTitle, byte[] uploadedData,  String uploadedFilename, String uploaderName
			, boolean assignForauthorization, String assignedAuthorizerName) throws DmsException;
	
	List<String> getAuthorizerListWhenCreatorIs(String creatorName) throws DmsException;

	Map<String, Object> getPaperContents(String paperid)  throws DmsException;

	Map<String, Object> getPaperDetails(long papernumber);
	
	List<String> getActionTextNamesList();
	
	List<String> getUsernamelistWhenworkflowIs(String workflowId);
	
	Map<String, Object> getWorkflowLaunchMap(String workflowId);

}
