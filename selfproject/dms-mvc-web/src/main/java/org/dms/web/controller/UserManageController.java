package org.dms.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.dms.web.bo.ConstantsService;
import org.dms.web.bo.UserService;
import org.dms.web.core.JsonUtil;
import org.dms.web.entity.User;
import org.dms.web.exception.DmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/usermanage")
public class UserManageController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ConstantsService constantsService;
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/rolelist",method={RequestMethod.GET})
	public String getUserRolesJSON(){
		log.info("getting list of roles for user as json ...");
		List<String> roles = constantsService.findAllValuesForVariable("ACCESS TYPE");
		return JsonUtil.getJsonAsString(roles);
	}
	
	@ResponseBody
	@RequestMapping(value="/usernamelist",method={RequestMethod.GET})
	public String getUserNamesListJSON(){
		log.info("getting list of usernames as json ...");
		List<String> names = new ArrayList<String>();
		try {
			names =  userService.allUsersNameList();
		} catch (DmsException e) {
			log.error("error in getting all user names", e);
		}		
		return JsonUtil.getJsonAsString(names);
	}
	
	@ResponseBody
	@RequestMapping(value="/add")
	public String addNewUserJSON(@RequestParam(value="uname") String username
			, @RequestParam(value="passwd") String password
			,@RequestParam(value="addr") String address
			,@RequestParam(value="email") String email
			,@RequestParam(value="role") String role){
		log.info("adding new user ... ["+username+","+password+","+address+","+email+","+role+"].");
		String result = new String();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			result = userService.addNewUser(username, password, address, email, role);
			resultMap.put("msg", result);	
			result = JsonUtil.getJsonAsString(resultMap);
		} catch (Exception e) {		
			resultMap.put("msg", ExceptionUtils.getRootCauseMessage(e));
			result = JsonUtil.getJsonAsString(resultMap);
			log.error("error in adding new user ... ", e);
		}
		log.info(result);
		return result;
	}	
	
	@ResponseBody
	@RequestMapping(value="/delete/{tempid}")
	public String deleteUserJson(@PathVariable("tempid") String userid){
		log.info("deleting user with id "+ userid + " ...");
		String result = new String();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			result = userService.deleteUserHavingId(userid);
			resultMap.put("msg", result);	
			result = JsonUtil.getJsonAsString(resultMap);
		} catch (Exception e) {
			resultMap.put("msg", ExceptionUtils.getRootCauseMessage(e));
			result = JsonUtil.getJsonAsString(resultMap);
			log.error("error in deleting user ...", e);
		}
		log.info(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/allusers")
	public String getAllUsersJson(){
		log.info("getting all users ...");
		String result = new String();		
		try {
			List<User> userslist= userService.allUsersList();
			result = JsonUtil.getJsonAsString(userslist);
		} catch (Exception e) {
			Map<String, Object> errmap = new HashMap<String, Object>();
			errmap.put("msg", ExceptionUtils.getRootCauseMessage(e));
			result = JsonUtil.getJsonAsString(errmap);
		}
		log.info(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/allusers/pdf")
	public void getAllUsersPdf(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		 response.setContentType("application/pdf");
		 /* To prompt browser to ask to save file */
		 response.setHeader("Content-Disposition","attachment;filename=dms-users.pdf");
		 byte[] pdf = userService.buildPdfListOfAllUsers();	    
		 response.getOutputStream().write(pdf);
	}
	
	@ResponseBody
	@RequestMapping(value="/user/{tempid}")
	public String getUserDetailsJson(@PathVariable("tempid") String userid){
		log.info("finding user with id "+ userid + " ...");
		String result = "";
		try {
			User user = userService.findUserHavingId(userid);
			result = JsonUtil.getJsonAsString(user);
			result = StringUtils.isEmpty(result) ? "" : result;
		} catch (Exception e) {			
			log.error("error in getting user details ...", e);
		}
		log.info(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/savechanges")
	public String saveChangesForUserJSON(@RequestParam(value="userid") Long userId
			,@RequestParam(value="uname") String username
			,@RequestParam(value="passwd") String password
			,@RequestParam(value="addr") String address
			,@RequestParam(value="email") String email
			,@RequestParam(value="role") String role){
		log.info("saving changes for user ... ["+userId+","+username+","+password+","+address+","+email+","+role+"].");
		String result = new String();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			result = userService.updateUser(userId,username, password, address, email, role);
			resultMap.put("msg", result);	
			result = JsonUtil.getJsonAsString(resultMap);
		} catch (Exception e) {		
			resultMap.put("msg", ExceptionUtils.getRootCauseMessage(e));
			result = JsonUtil.getJsonAsString(resultMap);
			log.error("error in saving changes for user ... ", e);
		}
		log.info(result);
		return result;
	}
	

}
