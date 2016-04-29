package org.dms.web.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dms.web.bo.WorkflowService;
import org.dms.web.core.SystemConstants;
import org.dms.web.document.PaperStatus;
import org.dms.web.document.PaperStores;
import org.dms.web.document.PaperWorkflow;
import org.dms.web.document.Users;
import org.dms.web.exception.DmsException;
import org.dms.web.repository.PaperStatusRepository;
import org.dms.web.repository.PaperStoresRepository;
import org.dms.web.repository.PaperWorkflowRepository;
import org.dms.web.repository.UsersRepository;
import org.dms.web.vo.PendingActionWorkflow;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkflowServiceImpl implements WorkflowService{

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private PaperWorkflowRepository workflowRepository;
	@Autowired
	private PaperStatusRepository paperStatusRepository;
	@Autowired
	private PaperStoresRepository paperStoresRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<PendingActionWorkflow> getWorkflowsPendingActions() throws DmsException {
		log.info("searching all workflows with any pending actions.");
		List<PendingActionWorkflow> tmpList = new ArrayList<PendingActionWorkflow>();
		for (PaperWorkflow wf : workflowRepository.findByCompletedIsFalse()) {
			tmpList.add(new PendingActionWorkflow(wf.getPaperStores().getNumber()
					, wf.getPaperStores().getTitle(), wf.getId(), wf.getComments(), wf.getAssignedToUser().getUsername()));
		}log.info(tmpList.size() +" Record(s) found.");
		return tmpList;
	}

	@Override
	public String completeWorkflow(String workflowfid, long papernumber,String papertitle
			, String action, String assignedToUsername,String currentUsername, String comments) throws DmsException{
		if (StringUtils.isEmpty(workflowfid)||StringUtils.isEmpty(action)||StringUtils.isEmpty(assignedToUsername)||StringUtils.isEmpty(currentUsername)) {
			throw new DmsException("One of the input fields is null or empty, unable to process workflow"); 	
		}
		Date currenttime = new Date();
		PaperWorkflow workflow =workflowRepository.findOne(workflowfid);
		PaperStores paper = workflow.getPaperStores();
		Users assignedUser = usersRepository.findOneByUsername(assignedToUsername);
		Users currentUser = usersRepository.findOneByUsername(currentUsername);		
		if (currentUser == null) {
			throw new DmsException("No user records found for name "+currentUsername+". Please try again.");
		}
		// If action = AUTHORIZE, complete the work flow and assign a new workflow for Approval.
		if (action.equalsIgnoreCase(SystemConstants.WF_ACTION_AUTHORIZE.getValue())) {
			if (assignedUser == null) {
				throw new DmsException("No user records found for name "+assignedToUsername+". Please try again.");
			}
			workflow.setCompletedByUserId(currentUser);
			workflow.setCompletionTime(currenttime);
			workflow.setComments(SystemConstants.PAPER_STATUS_AUTH.getValue());
			workflow.setCompleted(true);			
			PaperStatus paperStatus = paperStatusRepository.findOneByPaperStores(paper);
			if (paperStatus.isAuthorized() == true) {
				throw new DmsException("Paper workflow already has a record for authorization. Either approve or reject.");
			}
			if (paperStatus.isRejected() == true) {
				throw new DmsException("Paper is already rejected. No further action can be taken.");
			}
			paperStatus.setAuthorizationTime(currenttime);
			paperStatus.setAuthorizedBy(currentUser);
			paperStatus.setAuthorized(true);
			paperStatus.setComments(paperStatus.getComments()+" \n"+currentUsername+": "+comments);
			workflowRepository.save(workflow);
			workflowRepository.save(new PaperWorkflow(paper, assignedUser, currenttime, null, false, null, SystemConstants.PAPER_STATUS__PEND_APPROVAL.getValue()));
			paperStatusRepository.save(paperStatus);
			return "Workflow authorized, Pending for approval by "+ assignedToUsername;
		}
		// If action = APPROVE, complete the work flow
		if (action.equalsIgnoreCase(SystemConstants.WF_ACTION_APPROVE.getValue())) {
			workflow.setCompletedByUserId(currentUser);
			workflow.setCompletionTime(currenttime);
			workflow.setComments(SystemConstants.PAPER_STATUS_APPROVED.getValue());
			workflow.setCompleted(true);			
			PaperStatus paperStatus = paperStatusRepository.findOneByPaperStores(paper);
			if (paperStatus.isAuthorized() == false) {
				throw new DmsException("Paper should be authorized before approving.");
			}
			if (paperStatus.isRejected() == true) {
				throw new DmsException("Paper is already rejected. No further action can be taken.");
			}
			paperStatus.setApprovalTime(currenttime);
			paperStatus.setApprovedBy(currentUser);
			paperStatus.setApproved(true);
			paperStatus.setComments(paperStatus.getComments()+" \n"+currentUsername+": "+comments);
			workflowRepository.save(workflow);
			paperStatusRepository.save(paperStatus);
			return "Workflow approved by "+ currentUsername;
		}
		// If action = REJECT, complete the work flow
		if (action.equalsIgnoreCase(SystemConstants.WF_ACTION_REJECT.getValue())) {
			workflow.setCompletedByUserId(currentUser);
			workflow.setCompletionTime(currenttime);
			workflow.setComments(SystemConstants.PAPER_STATUS_REJECTED.getValue());
			workflow.setCompleted(true);			
			PaperStatus paperStatus = paperStatusRepository.findOneByPaperStores(paper);
			if (paperStatus.isApproved() == true) {
				throw new DmsException("Paper is already approved, cannot reject it now.");
			}
			paperStatus.setRejectionTime(currenttime);
			paperStatus.setRejectedBy(currentUser);
			paperStatus.setRejected(true);
			paperStatus.setComments(paperStatus.getComments()+" \n"+currentUsername+": "+comments);
			workflowRepository.save(workflow);
			paperStatusRepository.save(paperStatus);
			return "Workflow rejected by "+ currentUsername;
		}
		return "Unable to process, I dont know.";
	}
}
