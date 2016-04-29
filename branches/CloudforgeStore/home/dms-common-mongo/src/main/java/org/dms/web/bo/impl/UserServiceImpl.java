package org.dms.web.bo.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dms.web.bo.UserService;
import org.dms.web.core.PdfUtil;
import org.dms.web.document.Users;
import org.dms.web.exception.DmsException;
import org.dms.web.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class UserServiceImpl implements UserService{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private UsersRepository usersRepository;

	/* 
	 * Function to add new user to system.
	 */
	@Override
	public String addNewUser(String username, String password, String address, String email, String role) throws DmsException {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(address) || StringUtils.isEmpty(email) || StringUtils.isEmpty(role) ){
			return "Input param(s) is/are null or empty. please retry.";
		}
		Users newuser = new Users(username, password, address, email, role);
		newuser = usersRepository.save(newuser);
		log.info("New record insert into db completed - "+ newuser);
		return "New system user added sucessfully (ID = "+ newuser.getId() + "), '"+username+"' may now login with his/her credentials.";
	}

	@Override
	public String deleteUserHavingId(String userId) throws DmsException {		
		return "Deleted "+usersRepository.deleteUsersById(userId)+" user(s) with id as "+userId+".";
	}

	@Override
	public String deleteUserHavingName(String username) throws DmsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(String userid, String username, String password, String address, String email, String role) throws DmsException {
		Users usr = new Users(username, password, address, email, role);
		usr.setId(userid);
		usr = usersRepository.save(usr);
		log.info("Updated user record, final contents as in db - "+ usr);
		return "Updated user having id as "+ usr.getId();
	}

	@Override
	public Users findUserHavingId(String userId) throws DmsException {
		return usersRepository.findOneById(userId);
	}

	@Override
	public Users findUserHavingName(String username) throws DmsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findUsersWithNameLike(String uname) throws DmsException {
		return usersRepository.findByUsernameRegex(uname);
	}

	@Override
	public List<String> allUsersNameList() throws DmsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> allUsersList() throws DmsException {
		return usersRepository.findAll();
	}

	@Override
	public byte[] buildPdfListOfAllUsers() {
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()){
			Document document = new Document(PageSize.A4, 10, 10, 50, 50);
			PdfWriter.getInstance(document, os);
			document.open();
			PdfUtil.addHeader(document);
			String[] tableColumnNames = {"USER ID","NAME","PASSWORD","ADDRESS","EMAIL","ROLE"};
			List<ArrayList<Object>> tabdatalist = new LinkedList<ArrayList<Object>>();
			List<Users> usersList = allUsersList();
			for (Users user : usersList) {
				ArrayList<Object> rowdata = new ArrayList<Object>();
				rowdata.add(user.getId());
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
	
	

}
