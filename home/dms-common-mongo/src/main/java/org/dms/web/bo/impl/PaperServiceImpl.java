package org.dms.web.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dms.web.bo.PaperService;
import org.dms.web.core.SystemConstants;
import org.dms.web.dao.SequenceDao;
import org.dms.web.document.PaperStatus;
import org.dms.web.document.PaperStores;
import org.dms.web.document.PaperWorkflow;
import org.dms.web.document.Users;
import org.dms.web.exception.DmsException;
import org.dms.web.exception.DmsRuntimeException;
import org.dms.web.repository.PaperStatusRepository;
import org.dms.web.repository.PaperStoresRepository;
import org.dms.web.repository.PaperWorkflowRepository;
import org.dms.web.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PaperServiceImpl implements PaperService {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private PaperStoresRepository paperStoresRepository;
	@Autowired
	private PaperStatusRepository statusRepository;
	@Autowired
	private PaperWorkflowRepository workflowRepository; 
	@Autowired
	private SequenceDao sequenceDao;
	
	/* 
	 * To add new paper to system.
	 */
	@Override
	public String addNewPaperToStore(String paperTitle, byte[] uploadedData, String uploadedFilename, String uploaderName, boolean assignForauthorization,String assignedAuthorizerName) throws DmsException {
		if(StringUtils.isEmpty(paperTitle)||StringUtils.isEmpty(uploaderName)||StringUtils.isEmpty(assignedAuthorizerName)){
			throw new DmsException( "either of paper title/owner name/assigned username is null or empty");
		}
		Date currentDatetime = new Date();
		Users creator = usersRepository.findOneByUsername(uploaderName);
		Users authorizer =usersRepository.findOneByUsername(assignedAuthorizerName);
		if (creator == null) {
			throw new DmsRuntimeException("No record of user having name as "+uploaderName+" found in database.");
		}
		if (authorizer == null) {
			throw new DmsRuntimeException("No record of user having name as "+authorizer+" found in database.");
		}
		
		/* create new paper record, status info and workflow for this newly created paper. */
		PaperStores paperstores = paperStoresRepository.save(new PaperStores(sequenceDao.getNextSequenceId(SystemConstants.PAPER_STORES_SEQUENCE.getValue())
				, paperTitle, uploadedData, uploadedFilename, creator, currentDatetime));
		log.info("saved new record to paper stores at "+ paperstores.getId());
		PaperStatus paperStatus = statusRepository.save(new PaperStatus(paperstores, false, uploaderName+": New paper '"+paperTitle+"' uploaded"));		
		log.info("saved new record for paper status at "+ paperStatus.getId());
		PaperWorkflow workflow = workflowRepository.save(new PaperWorkflow(paperstores, creator, currentDatetime
				, creator, true, currentDatetime, SystemConstants.PAPER_STATUS_CREATED.getValue()));
		log.info("saved new workflow record for paper creation completion at "+ workflow.getId());
		
		/* Create a new workflow for authorization pending */
		workflow = workflowRepository.save(new PaperWorkflow(paperstores, authorizer, currentDatetime
				, null, false, null, SystemConstants.PAPER_STATUS_PEND_AUTH.getValue()));
		log.info("saved new paper authorization pending workflow");
		return "New paper {number: "+paperstores.getNumber()+"} stored into database.";
	}

	@Override
	public List<String> getAuthorizerListWhenCreatorIs(String creatorName) throws DmsException {
		List<String> tmpList = new ArrayList<String>();
		if (StringUtils.isEmpty(creatorName)) {
			throw new DmsException("file creator's name not received.");
		}
		Users creator = usersRepository.findOneByUsername(creatorName);
		if (creator == null) {
			throw new DmsException(creatorName +" is not a valid system user name.");
		}
		for(Users usr : usersRepository.findByUsernameNotAndRoleNot(creatorName, SystemConstants.ROLE_STUDENT.getValue())){
			tmpList.add(usr.getUsername());
		}
		log.info("found LOVs of possible authorizers name as "+ tmpList);
		return tmpList;
	}

	@Override
	public Map<String, Object> getPaperContents(String paperid) throws DmsException {
		PaperStores paper = paperStoresRepository.findOne(paperid);
		Map<String, Object> map = null;
		if(paper != null) {
			map = new HashMap<String, Object>();
			map.put("data", paper.getData());
			map.put("filename", paper.getOriginalFilename());
		}
		return map;
	}

	@Override
	public Map<String, Object> getPaperDetails(long papernumber) {
		Map<String, Object> paperDetailsMap = new HashMap<String, Object>();
		PaperStores paper = paperStoresRepository.findOneByNumber(papernumber);
		paperDetailsMap.put("paperstore", paper);
		PaperStatus status = statusRepository.findOneByPaperStores(paper);
		paperDetailsMap.put("paperstatus", status);
		List<PaperWorkflow> wfList = workflowRepository.findByPaperStores(paper);
		paperDetailsMap.put("paperworkflowlist", wfList);
		return paperDetailsMap;
	}

	@Override
	public List<String> getActionTextNamesList() {
		List<String> tmpList = new ArrayList<String>();
		tmpList.add(SystemConstants.WF_ACTION_AUTHORIZE.getValue());
		tmpList.add(SystemConstants.WF_ACTION_APPROVE.getValue());
		tmpList.add(SystemConstants.WF_ACTION_REJECT.getValue());
		return tmpList;
	}

	@Override
	public List<String> getUsernamelistWhenworkflowIs(String workflowId) {
		List<String> tmpList = new ArrayList<String>();
		if (StringUtils.isNotEmpty(workflowId)) {
			// Find all usernames who don't have roles as Student.
			for (Users user : usersRepository.findByRoleNot(SystemConstants.ROLE_STUDENT.getValue())) {
				tmpList.add(user.getUsername());
			}
			// Find all usernames previously assigned and remove from final list
			PaperWorkflow workflow = workflowRepository.findOne(workflowId);
			PaperStores paper =workflow.getPaperStores();
			for (PaperWorkflow wf : workflowRepository.findByPaperStores(paper)) {
				if (wf.getAssignedToUser() != null && StringUtils.isNotEmpty(wf.getAssignedToUser().getUsername())) {
					tmpList.remove(wf.getAssignedToUser().getUsername());
				}			
				if (wf.getCompletedByUser()!=null && StringUtils.isNotEmpty(wf.getCompletedByUser().getUsername())) {
					tmpList.remove(wf.getCompletedByUser().getUsername());
				}			
			}
		}
		return tmpList;
	}

	@Override
	public Map<String, Object> getWorkflowLaunchMap(String workflowId) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(workflowId)) {
			PaperWorkflow workflow =workflowRepository.findOne(workflowId);
			PaperStores paper = workflow.getPaperStores();
			map.put("workflowid", workflowId);
			map.put("papernumber", paper.getNumber());
			map.put("papertitle", paper.getTitle());			
		}
		return map;
	}
	
	

}
