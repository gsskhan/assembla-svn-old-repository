package com.citi.retail.optima.etl.batch.dao.impl.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.batch.dao.impl.BatchJobInstanceDaoImpl;
import com.citi.retail.optima.etl.common.model.FileInformation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/retail.optima.etl.batch.test.xml" })
public class BatchJobInstanceDaoImplTest {

	@Autowired
	private BatchJobInstanceDaoImpl jobInstanceDao;

	@Test
	public void testOriginalMessageId() throws Exception {
		int msgId = jobInstanceDao.getOriginalMessageId(5019);

		Assert.assertNotEquals(0, msgId);
	}

	@Test
	public void testGetFileInformation() throws Exception {
		List<FileInformation> file = jobInstanceDao.getFileInformation(5019);

		Assert.assertNotNull(file);
	}

}
