package com.citi.gpa.test.mongo;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.citi.gpa.constants.HqlQueryOne;
import com.citi.gpa.dao.GenericDao;
import com.citi.gpa.document.EtsApp;
import com.citi.gpa.document.EtsAppDatIntXref;
import com.citi.gpa.document.EtsAppIfXref;
import com.citi.gpa.document.EtsAppStatus;
import com.citi.gpa.document.EtsDataInterface;
import com.citi.gpa.document.EtsInfrastructure;
import com.citi.gpa.entity.App;
import com.citi.gpa.entity.AppDatIntXref;
import com.citi.gpa.entity.DataInterface;
import com.citi.gpa.entity.Infrastructure;
import com.citi.gpa.repository.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/applicationContext-hibernate.xml","/spring/applicationContext-mongo.xml"})
@TransactionConfiguration(transactionManager = "txManager" )
@Transactional
public class BulkOperationTest {
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private GenericDao genericDao;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private EtsAppRepository etsAppRepository;
	@Autowired
	private EtsDataInterfaceRepository dataInterfaceRepository;
	@Autowired
	private EtsInfrastructureRepository infrastructureRepository;
	@Autowired
	private EtsAppDatIntXrefRepository etsAppDatIntXrefRepository;
	
	@Before
	public void beforeRun(){
		if (! mongoTemplate.collectionExists(EtsApp.class)) {
			log.info("creating collection for EtsApp.class ...");
			mongoTemplate.createCollection(EtsApp.class);
		} else {
			log.info("found collection for EtsApp.class ...");
		}
		if (! mongoTemplate.collectionExists(EtsAppStatus.class)) {
			log.info("creating collection for EtsAppStatus.class ...");
			mongoTemplate.createCollection(EtsAppStatus.class);
		}
		else {
			log.info("found collection for EtsAppStatus.class ...");
		}
		if (! mongoTemplate.collectionExists(EtsDataInterface.class)) {
			log.info("creating collection for EtsDataInterface.class ...");
			mongoTemplate.createCollection(EtsDataInterface.class);
		}
		else {
			log.info("found collection for EtsDataInterface.class ...");
		}
		if (! mongoTemplate.collectionExists(EtsInfrastructure.class)) {
			log.info("creating collection for EtsInfrastructure.class ..." );
			mongoTemplate.createCollection(EtsInfrastructure.class);
		}
		else {
			log.info("found collection for EtsInfrastructure.class ...");
		}
		
		if (! mongoTemplate.collectionExists(EtsAppDatIntXref.class)) {
			log.info("creating collection for EtsAppDatIntXref.class ..." );
			mongoTemplate.createCollection(EtsAppDatIntXref.class);
		}
		else {
			log.info("found collection for EtsAppDatIntXref.class ...");
		}
		
		if (! mongoTemplate.collectionExists(EtsAppIfXref.class)) {
			log.info("creating collection for EtsAppIfXref.class ..." );
			mongoTemplate.createCollection(EtsAppIfXref.class);
		}
		else {
			log.info("found collection for EtsAppIfXref.class ...");
		}
	}
	
	@Test
	@Ignore
	public void testAddAllApps(){
		log.info("Executing program to fetch all apps from oracle db and insert into mongodb ...");
		List<App> listOfAllApps = genericDao.getList("from App", null, HqlQueryOne.MAX_RESULTSET_LIMIT.getValue());
		log.info("found "+ listOfAllApps.size() +" apps from oracle db.");
		Assert.assertNotNull(listOfAllApps);
		
		log.info("Inserting all apps into mongo db.");				
		for (App app : listOfAllApps) {
			EtsApp appdoc = new EtsApp(app.getAppId(),app.getAppCsiId(),app.getAppName(),app.getAppDesc(),app.getAppStatus());
			log.info("saving - " + appdoc);
			//check if app record exist in mongo.
			EtsApp savedApp = mongoTemplate.findOne(Query.query(Criteria.where("appid").is(app.getAppId())), EtsApp.class);
			if (savedApp != null && appdoc.getAppId() == savedApp.getAppId()) {
				log.info("skipped... already existing in mongo db");
			} else {
				mongoTemplate.insert(appdoc);
				log.info("saved successfully.");				
			}			
		}		
		long totalrecords = mongoTemplate.count(new Query(), EtsApp.class);
		log.info("Total records on mongo = "+ totalrecords);
		log.info("completed ...");		
	}
	
	@Test
	@Ignore
	public void displayAllApps(){
		log.info("Displaying all apps ...");
		for (EtsApp etsApp : mongoTemplate.findAll(EtsApp.class)) {
			log.info(etsApp);
		}
		log.info("completed ...");
		
	}
	
	@Test
	@Ignore
	public void displayAllAppsSelectedFeilds(){
		log.info("Displaying all apps (csi id and name) ...");
		Query query = new Query();
		query.fields().include("appCsiId");
		query.fields().include("appName");
		for (EtsApp etsApp : mongoTemplate.find(query, EtsApp.class)) {
			log.info(etsApp);
		}
		log.info("completed ...");
		
	}
	
	@Test
	@Ignore
	public void testAddAllAppStatus(){
		log.info("Executing program to add status to AppStatus ...");
		List<EtsApp> allAppsList = mongoTemplate.find(new Query(), EtsApp.class);
		log.info("found "+ allAppsList.size() +" apps in mongo.");
		
		/* Add Critical ie 1 for Optima and Warning ie 2 for CE, rest as Normal ie 3 only.
		   Set description of Application as Upper case */
		for (EtsApp etsApp : allAppsList) {
			int status;
			long appId = etsApp.getAppId();
			if (appId == 1) {
				status = 1;
			} else if (appId == 2) {
				status = 2;
			} else {
				status = 3;
			}			
			EtsAppStatus newAppStatus = new EtsAppStatus(appId , status , etsApp );
			
			// check if appstatus record exist.
			EtsAppStatus oldAppStatus = mongoTemplate.findOne(Query.query(Criteria.where("appid").is(appId)), EtsAppStatus.class);
			if( oldAppStatus != null && oldAppStatus.getAppId() == newAppStatus.getAppId()){
				log.info("already exists ...");
				// Update first Dbref property Document
				mongoTemplate.updateMulti( Query.query(Criteria.where("appid").is(etsApp.getAppId())), Update.update("desc", etsApp.getAppDesc().toUpperCase()), EtsApp.class);
				// Update Dbref property containing Document
				mongoTemplate.updateMulti( Query.query(Criteria.where("appid").is(appId)) , Update.update("status", status) , EtsAppStatus.class);
				log.info("update successful - " + mongoTemplate.findOne(Query.query(Criteria.where("appid").is(appId)), EtsAppStatus.class));
			} else {
				mongoTemplate.insert(newAppStatus);
				log.info("insert successful - " + newAppStatus);	
			}					
		}
		long totalrecords = mongoTemplate.count(new Query(), EtsAppStatus.class);
		log.info("Total records on mongo = "+ totalrecords);
		log.info("completed ...");		
	}
	
	@Test
	@Ignore
	public void displayAllAppStatus(){
		log.info("Displaying all App Status ...");
		for (EtsAppStatus appStatus : mongoTemplate.findAll(EtsAppStatus.class)) {
			log.info(appStatus);
		}
		log.info("completed ...");		
	}	
	
	
	@Test
	@Ignore
	public void findAndDisplayOneAppStatus(){
		log.info("Displaying 'RAPID' Status ...");
		// first find RAPID records in EtsApp
		EtsApp etsApp = mongoTemplate.findOne(Query.query(Criteria.where("name").is("RAPID")), EtsApp.class);
		log.info("Found EtsApp - "+ etsApp);
		// then using the object found above, find the record in EtsAppStatus.
		EtsAppStatus etsAppStatus = mongoTemplate.findOne(Query.query(Criteria.where("etsApp.$id").is(new ObjectId(etsApp.getId()))), EtsAppStatus.class);		
		log.info("Found - "+ etsAppStatus);
		Assert.assertEquals("RAPID", etsAppStatus.getEtsApp().getAppName());
		log.info("completed ...");		
	}
	
	@Test
	@Ignore
	public void testAddDataInterface(){ 
		log.info("Adding Data interface data From Oracle to mongo db ...");
		List<DataInterface> listfromSource = genericDao.listEntityWhereEq(DataInterface.class, null, HqlQueryOne.MAX_RESULTSET_LIMIT.getValue());
		log.info("Total records found from source - " + listfromSource.size());
		
		log.info("Adding records to mongodb ...");
		for (DataInterface dataInt : listfromSource) {
			EtsDataInterface dataInterface = new EtsDataInterface(dataInt.getDataIntId(), dataInt.getDataIntCategory(), dataInt.getDataIntName(), dataInt.getDataIntDesc(), dataInt.getDataGenSys());
			
			// check if this record exists in mongo.
			boolean status = mongoTemplate.exists(Query.query(Criteria.where("dataIntId").is(dataInt.getDataIntId())), EtsDataInterface.class);
			if (status) {
				log.info("already exists.");
				Update update = new Update();
				update.set("dataIntName", dataInterface.getDataIntName());
				update.set("dataIntDesc", dataInterface.getDataIntDesc());
				update.set("dataGenSys", dataInterface.getDataGenSys());
				mongoTemplate.updateMulti(Query.query(Criteria.where("dataIntId").is(dataInt.getDataIntId())), update, EtsDataInterface.class);
				log.info("successfully updated.");
			} else {
				mongoTemplate.insert(dataInterface);
				log.info("successfully inserted.");
			}
			log.info(mongoTemplate.findOne(Query.query(Criteria.where("dataIntId").is(dataInt.getDataIntId())), EtsDataInterface.class));
		}	
		log.info("completed ...");		
	}
	
	@Test
	@Ignore
	public void displayDataInterface(){
		log.info("displaying all data interface");		
		List<EtsDataInterface> listAll = dataInterfaceRepository.findAll();
		Assert.assertNotNull(listAll);
		for (EtsDataInterface etsDataInterface : listAll) {
			log.info(etsDataInterface);
		}		
		log.info("completed ...");
	}
	
	@Test
	@Ignore
	public void testAddInfrastructure(){ 
		log.info("Adding Infrastructure data from oracle db to mongp db.");
		List<Infrastructure> allInfraList = genericDao.listEntityWhereEq(Infrastructure.class, null, HqlQueryOne.MAX_RESULTSET_LIMIT.getValue());
		log.info("found "+ allInfraList.size() +" records from oracle db. Begin inserting records in mongo db ...");
		for (Infrastructure infra : allInfraList) {
			EtsInfrastructure newInfraDoc = new EtsInfrastructure(infra.getIfId(), infra.getIfName(), infra.getIfCategory(), infra.getIfType(), infra.getLocation());
			
			// check if the record exits.
			boolean status = mongoTemplate.exists(Query.query(Criteria.where("ifId").is(infra.getIfId())), EtsInfrastructure.class);
			if (status) {
				log.info("already existing, proceed to update ...");
				Update update = new Update();
				update.set("ifName", infra.getIfName());
				update.set("ifCategory", infra.getIfCategory() );
				update.set("ifType", infra.getIfType());
				update.set("location", infra.getLocation());
				mongoTemplate.updateMulti(Query.query(Criteria.where("ifId").is(infra.getIfId())), update, EtsInfrastructure.class);
				log.info("updated successfully - " + mongoTemplate.find(Query.query(Criteria.where("ifId").is(infra.getIfId())), EtsInfrastructure.class));

			} else {
				newInfraDoc = infrastructureRepository.save(newInfraDoc);
				log.info("successfully inserted - " +newInfraDoc);
			}
		}	
		long totalRecords = infrastructureRepository.count();
		log.info("Total number of records in collection present = "+ totalRecords);
		log.info("completed ...");
	}
	
	@Test
	@Ignore
	public void addAllDataIntXref(){
		log.info("Adding AppDataIntXref to mongo db from oracle db ...");
		List<AppDatIntXref> list = genericDao.listEntityWhereEq(AppDatIntXref.class, null, HqlQueryOne.MAX_RESULTSET_LIMIT.getValue());
		log.info("found "+ list.size() +" records from oracle db. Begin inserting records in mongo db ...");
		
		for (AppDatIntXref appDatIntXref : list) {
			// Find etsApp Record.
			EtsApp app = mongoTemplate.findOne(Query.query(Criteria.where("appid").is(appDatIntXref.getApp().getAppId())), EtsApp.class);
			EtsDataInterface dataInterface =  mongoTemplate.findOne(Query.query(Criteria.where("dataIntId").is(appDatIntXref.getDataInterface().getDataIntId())), EtsDataInterface.class);
			EtsAppDatIntXref datIntXrefDoc = new EtsAppDatIntXref(appDatIntXref.getAppDatIntXrefId(), appDatIntXref.getDataIntType(), appDatIntXref.getAppDataIntSeverity(), 3, app, dataInterface);
			
			boolean status = mongoTemplate.exists(Query.query(Criteria.where("appDatIntXrefId").is(appDatIntXref.getAppDatIntXrefId())), EtsAppDatIntXref.class);
			if (status) {
				log.info("Record exists, proceed to update.");
				Update update = new Update();
				update.set("dataIntType", appDatIntXref.getDataIntType());
				update.set("appDataIntSeverity", appDatIntXref.getAppDataIntSeverity());
				update.set("dataIntstatus", 3);
				mongoTemplate.updateMulti(Query.query(Criteria.where("appDatIntXrefId").is(appDatIntXref.getAppDatIntXrefId())), update, EtsAppDatIntXref.class);
				log.info(etsAppDatIntXrefRepository.findOneByAppDatIntXrefId(appDatIntXref.getAppDatIntXrefId()));
			} else {
				datIntXrefDoc = etsAppDatIntXrefRepository.save(datIntXrefDoc);
				log.info("inserted successfully - "+ datIntXrefDoc);
			}
		}
		
		long totalRecords = etsAppDatIntXrefRepository.count();
		log.info("Total number of records in collection present = "+ totalRecords);
		log.info("completed ...");		
	}
	
}
