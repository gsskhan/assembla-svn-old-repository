package com.citi.gpa.test.controller;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "/spring/applicationContext-hibernate.xml",	"/spring/applicationContext-common.xml","/spring/applicationContext-mongo.xml" })
@TransactionConfiguration(transactionManager = "txManager")
@Transactional
public class GeneralControllerTest {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	@Ignore
	public void testGetAppDependency() throws Exception {
		log.info("performing mock call to get app dependency..");
		this.mockMvc.perform(get("/appdependency").accept(MediaType.APPLICATION_JSON))
	     .andExpect(status().isOk())
	     .andDo(MockMvcResultHandlers.print());	    
		log.info("end ....");
	}
	
	
	@Test
	@Ignore
	public void testGetAppDependencyForApp() throws Exception {
		log.info("performing mock call to get app dependency for application = 2..");
		this.mockMvc.perform(get("/appdependency/2").accept(MediaType.APPLICATION_JSON))
	     .andExpect(status().isOk())
	     .andDo(MockMvcResultHandlers.print());	    
		log.info("end ....");
	}
	
	@Test
	@Ignore
	public void testGetAppList() throws Exception {
		log.info("performing mock call to get app list..");
		this.mockMvc.perform(get("/internalapplist").accept(MediaType.APPLICATION_JSON))
	     .andExpect(status().isOk())
	     .andDo(MockMvcResultHandlers.print());	    
		log.info("end ....");
	}
	
	@Test
	@Ignore
	public void testGetAppDataInterfaceRecords() throws Exception {
		log.info("performing mock call to get data interface list for app Id = 13");
		this.mockMvc.perform(get("/datainterface/13").accept(MediaType.APPLICATION_JSON))
	     .andExpect(status().isOk())
	     .andDo(MockMvcResultHandlers.print());	    
		log.info("end ....");
	}
	
	@Test
	@Ignore
	public void testGetAppInfrastructureRecords() throws Exception {
		log.info("performing mock call to get infrastructure list for app Id = 1");
		this.mockMvc.perform(get("/infrastructure/1").accept(MediaType.APPLICATION_JSON))
	     .andExpect(status().isOk())
	     .andDo(MockMvcResultHandlers.print());	    
		log.info("end ....");
	}

}
