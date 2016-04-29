package org.dms.web.controller;

import org.apache.log4j.Logger;
import org.dms.web.constants.ViewConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value={"/home","/"}, method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getHomeView(){
		ModelAndView mav = new ModelAndView(ViewConstants.HOME_PAGE.getValue());
		log.info("Returning home view - " + mav.getViewName() );
		return mav;
	}
	
	@RequestMapping(value={"/adminhome"}, method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getAdminHomeView(){
		ModelAndView mav = new ModelAndView(ViewConstants.ADMIN_HOME_PAGE.getValue());
		log.info("Returning admin home view - " + mav.getViewName() );
		return mav;
	}
	
	
}
