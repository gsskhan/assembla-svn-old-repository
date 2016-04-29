package com.citi.retail.optima.etl.controller.file.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.controller.dao.JobMessageDao;
import com.citi.retail.optima.etl.controller.model.EventFileMapVO;



@RunWith(MockitoJUnitRunner.class)
public class DataAcquisitionHandlerTest {

	
	private DataAcquisitionHandler  dataAcquisitionHandler;
	
	@Mock
	private JobMessageDao jobMessageDao;
	

	private Message<File> message;
	
	@Before
	public void testBeforeJob() throws OptimaRetailApplicationException, FileNotFoundException {
		dataAcquisitionHandler = new DataAcquisitionHandler();
		dataAcquisitionHandler.setJobMessageDao(jobMessageDao);
		File path = new File("target/test-classes/files");
		dataAcquisitionHandler.setFileLocation( path.getAbsolutePath()+"/");
		File file = new File("./files/OR_CRD_TW_RSK_20130930_HIST_TW_20140131_Control_V6.cnt");	
		message = MessageBuilder.withPayload(file).build();		 
		EventFileMapVO eventFileMapVo = new EventFileMapVO();
		List<EventFileMapVO> controlFileEventDetails = new ArrayList<EventFileMapVO>();		
		eventFileMapVo.setReqEventId(10l);
		eventFileMapVo.setCntrlFileFlag(Boolean.TRUE);
		eventFileMapVo.setInputFileName("OR_CRD_TW[a-zA-Z0-9_]*HIST_TW[a-zA-Z0-9._]*Control[a-zA-Z0-9._]*.cnt");
		controlFileEventDetails.add(eventFileMapVo);				
		Mockito.when(jobMessageDao.getRequestLogId()).thenReturn(120l);
		Mockito.when(jobMessageDao.getAllControlFiles()).thenReturn(controlFileEventDetails);
		
	}
	
	@Test
	public void testReceiveFilePayload() throws OptimaRetailApplicationException {
		Mockito.when(jobMessageDao.getSupportingFilesInfo(10l)).thenReturn(getSupportingFiels(10));
		Assert.assertNotNull(dataAcquisitionHandler.receiveFilePayload(message));
		Assert.assertNotNull(dataAcquisitionHandler.getJobMessageDao());
	}
	
	@Test(expected=OptimaRetailApplicationException.class)
	public void testInvalidFiels() throws OptimaRetailApplicationException {
		List<EventFileMapVO> list = getSupportingFiels(10);
		list.get(5).setInputFileName("OR_CRD_TW[a-zA-Z0-9_]*HRST_TW_ECS_FICO[a-zA-Z0-9._]*.dat");
		Mockito.when(jobMessageDao.getSupportingFilesInfo(10l)).thenReturn(list);
		dataAcquisitionHandler.receiveFilePayload(message);
		
	}
		
	
	@Test(expected=OptimaRetailApplicationException.class)
	public void tesFileWIthInvalidMessage() throws OptimaRetailApplicationException {
		dataAcquisitionHandler.receiveFilePayload(null);		
	}	
	
	private List<EventFileMapVO> getSupportingFiels(long id) {
		List<EventFileMapVO> dataFileDetailsFromDB =new ArrayList<EventFileMapVO>();
		EventFileMapVO eventFileMapVo = new EventFileMapVO();
		eventFileMapVo.setReqEventId(10l);
		eventFileMapVo.setCntrlFileFlag(Boolean.FALSE);
		eventFileMapVo.setInputFileName("OR_CRD_TW[a-zA-Z0-9_]*HIST_TW_RNBW[a-zA-Z0-9_.]*.dat");
		dataFileDetailsFromDB.add(eventFileMapVo);
		eventFileMapVo = new EventFileMapVO();
		eventFileMapVo.setReqEventId(10l);
		eventFileMapVo.setCntrlFileFlag(Boolean.FALSE);
		eventFileMapVo.setInputFileName("OR_CRD_TW[a-zA-Z0-9_]*HIST_TW_ECS_EPP[a-zA-Z0-9._]*.dat");
		dataFileDetailsFromDB.add(eventFileMapVo);
		eventFileMapVo = new EventFileMapVO();
		eventFileMapVo.setReqEventId(10l);
		eventFileMapVo.setCntrlFileFlag(Boolean.FALSE);
		eventFileMapVo.setInputFileName("OR_CRD_TW[a-zA-Z0-9_]*HIST_TW_ECS_WO[a-zA-Z0-9._]*.dat");
		dataFileDetailsFromDB.add(eventFileMapVo);		
		eventFileMapVo = new EventFileMapVO();
		eventFileMapVo.setReqEventId(10l);
		eventFileMapVo.setCntrlFileFlag(Boolean.FALSE);
		eventFileMapVo.setInputFileName("OR_CRD_TW[a-zA-Z0-9_]*HIST_TW_ECS_TDR[a-zA-Z0-9._]*.dat");
		dataFileDetailsFromDB.add(eventFileMapVo);		
		eventFileMapVo = new EventFileMapVO();
		eventFileMapVo.setReqEventId(10l);
		eventFileMapVo.setCntrlFileFlag(Boolean.FALSE);
		eventFileMapVo.setInputFileName("OR_CRD_TW[a-zA-Z0-9_]*HIST_TW_ECS_REC[a-zA-Z0-9._]*.dat");
		dataFileDetailsFromDB.add(eventFileMapVo);		
		eventFileMapVo = new EventFileMapVO();
		eventFileMapVo.setReqEventId(10l);
		eventFileMapVo.setCntrlFileFlag(Boolean.FALSE);
		eventFileMapVo.setInputFileName("OR_CRD_TW[a-zA-Z0-9_]*HIST_TW_ECS_NTB[a-zA-Z0-9._]*.dat");
		dataFileDetailsFromDB.add(eventFileMapVo);		
		eventFileMapVo = new EventFileMapVO();
		eventFileMapVo.setReqEventId(10l);
		eventFileMapVo.setCntrlFileFlag(Boolean.FALSE);
		eventFileMapVo.setInputFileName("OR_CRD_TW[a-zA-Z0-9_]*HIST_TW_ECS_FICO[a-zA-Z0-9._]*.dat");
		dataFileDetailsFromDB.add(eventFileMapVo);		
		return dataFileDetailsFromDB;		
	}
}
