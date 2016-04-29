package org.dms.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.dms.web.constants.ViewConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/logout",method={RequestMethod.GET,RequestMethod.POST})
	private ModelAndView doLogout(HttpSession session){
		ModelAndView mav = new ModelAndView(ViewConstants.HOME_PAGE.getValue());
		session.invalidate();
		log.info("Logged out.");
		return mav;
	}

}
