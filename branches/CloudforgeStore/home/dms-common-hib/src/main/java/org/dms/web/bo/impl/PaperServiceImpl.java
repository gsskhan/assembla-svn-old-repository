package org.dms.web.bo.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dms.web.bo.PaperService;
import org.dms.web.bo.UserService;
import org.dms.web.core.RandomNumberGenerator;
import org.dms.web.core.SystemConstants;
import org.dms.web.dao.GenericDao;
import org.dms.web.entity.PaperStatusInfo;
import org.dms.web.entity.PaperStore;
import org.dms.web.entity.PaperWorkflow;
import org.dms.web.entity.User;
import org.dms.web.exception.DmsException;
import org.dms.web.exception.DmsRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;

public class PaperServiceImpl implements PaperService {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private GenericDao genericDao;
	@Autowired
	private UserService userService;
	@Autowired
	private RandomNumberGenerator randumNumber;	
	
	private Map<String, Object> hqlparam = new HashMap<String, Object>();
	
	@Override
	public String addNewPaperToStore(String paperTitle,String filename, byte[] uploadedData, String uploaderName, boolean assignForauthorization, String assignedAuthorizerName) throws DmsException {
		if (StringUtils.isEmpty(uploaderName) || StringUtils.isEmpty(paperTitle) || StringUtils.isEmpty(assignedAuthorizerName) || !assignForauthorization ) {
			throw new DmsException("one/more parameters received incorrect/empty/required. [UploaderName = "+ uploaderName +", PaperTitle= "+ paperTitle
								+", AssignForAuthorization= "+ assignForauthorization+", AssignedAuthorizerName= "+ assignedAuthorizerName+"].");
		}		
		Timestamp currentTime = new Timestamp(new Date().getTime());
		User creator = userService.findUserHavingName(uploaderName);
		User authorizer = userService.findUserHavingName(assignedAuthorizerName);
		if (creator == null) {
			throw new DmsRuntimeException("No record of user having name as "+uploaderName+" found in database.");
		}
		if (authorizer == null) {
			throw new DmsRuntimeException("No record of user having name as "+authorizer+" found in database.");
		}
		/* create new paper record, status info and workflow for this newly created paper. */
		PaperStore paper = new PaperStore(randumNumber.getRandomLong(), paperTitle, filename, uploadedData, creator.getUserId(), currentTime, null, null, null);
		log.info("To be saved paper contents = "+ paper);
		genericDao.saveEntity(paper);
		log.info("saved new paper, id = "+ paper.getPaperStoreId());
		PaperStatusInfo statusInfo= new PaperStatusInfo(paper, false,  "new paper '"+paperTitle +"' has been uploaded.");
		genericDao.saveEntity(statusInfo);
		log.info("saved new paper status info , id = "+ statusInfo.getPaperStatusId());
		PaperWorkflow workflow = new PaperWorkflow(paper, creator.getUserId(), currentTime, true, creator.getUserId(), currentTime, SystemConstants.PAPER_STATUS_CREATED.getValue() +" - "+ paperTitle);
		genericDao.saveEntity(workflow);
		log.info("saved new paper creation workflow , id = "+ workflow.getWorkflowId());
		/* Create a new workflow for authorization pending */
		PaperWorkflow authoWorkflow = new PaperWorkflow(paper, authorizer.getUserId(), currentTime, false, 0, null, SystemConstants.PAPER_STATUS_PEND_AUTH.getValue());
		genericDao.saveEntity(authoWorkflow);
		log.info("saved paper aothorization pending workflow , id = "+ authoWorkflow.getWorkflowId());
		return "New paper {number - "+paper.getPaperNumber()+"} stored into database.";
	}

	/**
	 * All types of users except the "Creator of paper" and "Student" cannot be authorizer. 
	 * @return list of system user names who could be chosen for authorizing a paper.
	 * @param creatorName name of the system user who is creating/uploading the paper initially. 
	 */
	@Override
	public List<String> getAuthorizerListWhenCreatorIs(String creatorName) throws DmsException {
		List<String> tmpList = new ArrayList<String>();
		if (StringUtils.isEmpty(creatorName)) {
			throw new DmsException("creator's name not received.");
		}
		User creator = userService.findUserHavingName(creatorName);
		if (creator == null) {
			throw new DmsException(creatorName +" is not a valid system user name.");
		}
		hqlparam.clear();
		String hql = " select distinct username from User where username != :vname "
					+ "and role != :vrole ";
		hqlparam.put("vname", creatorName);
		hqlparam.put("vrole", SystemConstants.ROLE_STUDENT.getValue());
		tmpList = genericDao.getList(hql, hqlparam, 1000000);
		log.info("found "+tmpList.size()+" possible authorizer names.");
		return tmpList;
	}

	/**
	 * @return the complete paper details having title or number as passed in parameters
	 */
	@Override
	public PaperStore getPaper(String paperTitle, String paperNumber) throws DmsException {		
		if (StringUtils.isEmpty(paperTitle) && StringUtils.isEmpty(paperNumber)) {
			throw new DmsRuntimeException("paper title and number both can't be null/empty/zero.");
		}
		PaperStore paperStore = new PaperStore();
		hqlparam.clear();
		if ( StringUtils.isNumeric(paperNumber)) {
			hqlparam.put("paperNumber", Long.parseLong(paperNumber));
			paperStore = genericDao.getEntityWhereEq(PaperStore.class, hqlparam);		
		} else if (StringUtils.isNotEmpty(paperTitle)) {
			hqlparam.put("paperTitle", paperTitle);
			paperStore = genericDao.getEntityWhereEq(PaperStore.class, hqlparam);			
		}
		return paperStore;
	}

}
