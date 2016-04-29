package com.citi.retail.optima.etl.batch.test.processor;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.citi.retail.optima.etl.batch.job.processor.ValidationProcessor;
import com.citi.retail.optima.etl.common.model.OptimaRetailAccount;
import com.citi.retail.optima.etl.validation.vo.TestOptimaValidationVO;


@ContextConfiguration({ "/batch.validation.config.test.xml" })
public class ValidationProcessorTest {

	@Autowired
	ValidationProcessor<OptimaRetailAccount> validationProcessor;

	OptimaRetailAccount testVO = new OptimaRetailAccount();

	@Before
	public void setUp() {
		testVO.setPortfolioId(null);
		testVO.setFicoScore(1);
		testVO.setDeliquencyStartDt(new Date());
	}

	@Test
	public void processTest() throws Exception {
		Assert.assertNotNull(validationProcessor.process(testVO));
	}

	public ValidationProcessor<OptimaRetailAccount> getValidationProcessor() {
		return validationProcessor;
	}

	public void setValidationProcessor(
			ValidationProcessor<OptimaRetailAccount> validationProcessor) {
		this.validationProcessor = validationProcessor;
	}
}
