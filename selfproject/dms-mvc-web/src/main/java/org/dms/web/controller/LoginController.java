package org.dms.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.dms.web.bo.ConstantsService;
import org.dms.web.bo.LoginService;
import org.dms.web.constants.ViewConstants;
import org.dms.web.core.SystemConstants;
import org.dms.web.model.LoginUser;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/loginview")
@SessionAttributes({"sUserName","sUserRole"})
public class LoginController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private ConstantsService constantsService;
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){		
		log.info("Initializing form in initForm() and rendering view ...");		
		LoginUser luser = new LoginUser();
		model.addAttribute("user", luser);
		return ViewConstants.LOGIN_PAGE.getValue();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("user") @Valid LoginUser luser
			, BindingResult bindingResult
			, SessionStatus sessionStatus){
		log.info("processing login form ... "+ luser);
		ModelAndView mav = new ModelAndView(ViewConstants.LOGIN_PAGE.getValue());
		try {
			if (bindingResult.hasErrors()) {
				List<ObjectError> objerrlist = bindingResult.getAllErrors();
				String message = "";
				for (ObjectError objectError : objerrlist) {
					message = message.concat(objectError.getDefaultMessage() + " ; "); 
				}
				mav.addObject("msg", "Binding unsuccessfull, please retry. "+ message);
				return mav;
			}
			if (luser.getRole().equalsIgnoreCase(SystemConstants.ROLE_ADMIN.getValue())) {
				if (loginService.verifyAdminUser(luser.getUsername(), luser.getPassword(), luser.getRole())){
					mav.addObject("sUserName", luser.getUsername());
					mav.addObject("sUserRole", luser.getRole());
					mav.setViewName(ViewConstants.ADMIN_HOME_PAGE.getValue());
					return mav;
				}				
			} else {
				mav.addObject("msg", "Only administrator can login at the moment.");
			}
		} catch (HibernateException e) {
			mav.addObject("msg", e);
			log.error("backend service error ...", e);
		} catch (Exception e) {
			mav.addObject("msg", e);
			log.error("error.", e);
		}		
		return mav;
	}
	
	@ModelAttribute("roleList")
	public List<String> populateRoleList() {
		log.info("populating roles List ...");
		return constantsService.findAllValuesForVariable("ACCESS TYPE");
	}
		
	/** This method I am not sure - will have to check exact usage.
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		log.info("inside initBinder()...");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}*/

}
