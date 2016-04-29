package com.citi.gpa.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class NavController {
	
	private Logger log = Logger.getLogger(NavController.class);
	
	@RequestMapping(value="/home")
	public String getHomeView(){
		log.info("Returning home view.");
		return "home";
	}

}
