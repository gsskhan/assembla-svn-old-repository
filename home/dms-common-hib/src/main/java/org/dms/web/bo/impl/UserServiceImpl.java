package org.dms.web.bo.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dms.web.bo.UserService;
import org.dms.web.core.PdfUtil;
import org.dms.web.dao.GenericDao;
import org.dms.web.entity.User;
import org.dms.web.exception.DmsException;
import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class UserServiceImpl implements UserService{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private GenericDao genericDao;
	
	private Map<String, Object> hqlparam = new HashMap<String, Object>();
	
	@Override
	public String addNewUser(String username, String password, String address, 
			String email, String role)  throws DmsException{
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(address) 
				|| StringUtils.isEmpty(email) || StringUtils.isEmpty(role) ){
			return "Input param(s) is/are null or empty. please retry.";
		}
		User newUsr = new User(username,password,address,email,role);
		long savedUserId = (Long) genericDao.saveEntity(newUsr);
		return "New system user added sucessfully (ID = "+ savedUserId + "), "+username+" may now login with his/her credentials.";
	}
	
	@Override
	public String deleteUserHavingId(String userId) throws DmsException {
		long tmpUserId = Long.parseLong(userId);
		hqlparam.clear();
		hqlparam.put("dval", new Long(tmpUserId));
		int noOfRecordsDeleted = genericDao.delete("delete from User where userId = :dval", hqlparam);
		return "Deleted user. No of row(s) affected = " + noOfRecordsDeleted;		
	}
	
	@Override
	public String deleteUserHavingName(String username) throws DmsException {
		hqlparam.clear();
		hqlparam.put("vname", username);
		int noOfRecordsDeleted = genericDao.delete("delete from User where username = :vname", hqlparam);
		return "Deleted user. No of row(s) affected = " + noOfRecordsDeleted;
	}
	
	@Override
	public String updateUser(long userid, String username, String password,
			String address, String email, String role) throws DmsException {
		User tmpUser = new User(userid,username,password,address,email,role);
		genericDao.updateEntity(tmpUser);
		return "Successfully updated user " + tmpUser;
	}	

	@Override
	public User findUserHavingId(String userId) throws DmsException {
		long tmpUserId = Long.parseLong(userId);
		hqlparam.clear();
		hqlparam.put("uid", tmpUserId);
		User modUser = genericDao.getEntity("from User where userId = :uid ", hqlparam);		
		return modUser;
	}
	
	@Override
	public User findUserHavingName(String username) throws DmsException {
		hqlparam.clear();
		hqlparam.put("uname", username);
		User usr = genericDao.getEntity(" from User where username = :uname ", hqlparam);
		return usr;
	}
	
	@Override
	public List<User> findUsersWithNameLike(String keyword) throws DmsException{	
		List<User> tmpList = new ArrayList<User>();
		if (keyword == null || keyword.isEmpty()) {
			throw new NullPointerException("Please enter a valid keyword first.");
		}
		tmpList = genericDao.getList("from User where username like '%"+keyword+"%' ", null, 10000);
		return tmpList;
	}
	
	@Override
	public List<String> allUsersNameList() throws DmsException {
		return genericDao.getList("select distinct username from User", null, 1000);
	}
	
	@Override
	public List<User> allUsersList() throws DmsException{
		return genericDao.getList("from User", null, 1000);
	}
	
	@Override
	public byte[] buildPdfListOfAllUsers() {
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()){
			Document document = new Document(PageSize.LETTER, 50, 50, 50, 50);
			PdfWriter.getInstance(document, os);
			document.open();
			PdfUtil.addHeader(document);
			String[] tableColumnNames = {"USER ID","NAME","PASSWORD","ADDRESS","EMAIL","ROLE"};
			List<ArrayList<Object>> tabdatalist = new LinkedList<ArrayList<Object>>();
			List<User> usersList = allUsersList();
			for (User user : usersList) {
				ArrayList<Object> rowdata = new ArrayList<Object>();
				rowdata.add(user.getUserId());
				rowdata.add(user.getUsername());
				rowdata.add(user.getPassword());
				rowdata.add(user.getAddress());
				rowdata.add(user.getEmail());
				rowdata.add(user.getRole());
				tabdatalist.add(rowdata);
			}						
			PdfUtil.addTable(document, "All users", 6,tableColumnNames , tabdatalist);
			document.close();
			log.info("pdf built.");
			return os.toByteArray();
		} catch (DocumentException | IOException | DmsException e) {
			log.error("error in creating pdf.", e);
		}		
		return null;
	}

	// getter-setter methods
	public GenericDao getGenericDao() {
		return genericDao;
	}
	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}	

}
