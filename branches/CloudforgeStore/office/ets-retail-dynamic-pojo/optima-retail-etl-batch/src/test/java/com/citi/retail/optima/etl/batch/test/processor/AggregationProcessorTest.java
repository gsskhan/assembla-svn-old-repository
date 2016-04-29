/**
 * 
 */
package com.citi.retail.optima.etl.batch.test.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.citi.optima.retail.batch.job.timer.TimeTracker;
import com.citi.retail.optima.etl.aggregation.impl.AggregationServiceFactoryImpl;
import com.citi.retail.optima.etl.aggregation.model.AggregationRuleLookup;
import com.citi.retail.optima.etl.batch.job.processor.AggregationProcessor;
import com.citi.retail.optima.etl.cache.lookup.AggregationRulesLookup;
import com.citi.retail.optima.etl.cache.lookup.AggregationSqlRuleLookup;
import com.citi.retail.optima.etl.cache.model.AggregationSqlRef;
import com.citi.retail.optima.etl.common.ETLConstants;
import com.citi.retail.optima.etl.common.exception.OptimaRetailApplicationException;
import com.citi.retail.optima.etl.common.model.AggregationType;
import com.citi.retail.optima.etl.common.model.SupplementaryDataRecord;

/**
 * @author mc56120
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class AggregationProcessorTest {
	
	private AggregationProcessor<SupplementaryDataRecord> aggregationProcessor;
	private SupplementaryDataRecord modelObj;
	private StepExecution stepExecution;
	
	//@Mock
	//private AggregationSqlRuleLookup aggregationSqlLookup;
	
	@Mock
	private AggregationRuleLookup aggregationRulesLookup;
	
	private AggregationServiceFactoryImpl aggregationServiceFactory;

	@Before
	public void setUp() throws Exception {/*
		aggregationProcessor = new AggregationProcessor();
		aggregationServiceFactory = new AggregationServiceFactoryImpl();
		aggregationServiceFactory.setAggregationRuleLookup(aggregationRulesLookup);
		//aggregationServiceFactory.setAggregationSqlLookup(aggregationSqlLookup);
		ExpressionParser parser = new SpelExpressionParser();
		aggregationServiceFactory.setParser(parser);
		aggregationProcessor.setAggregationServiceFactory(aggregationServiceFactory);
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addLong(ETLConstants.BATCH_INSTANCE_ID, 1648l);
		jobParametersBuilder.addLong(ETLConstants.BATCH_ID, 9l);
		
		JobParameters jbs = jobParametersBuilder.toJobParameters();		
		JobExecution jobExecution = new JobExecution(new JobInstance(
				System.currentTimeMillis(), jbs, "Internal"));	
		ExecutionContext jobContext = new ExecutionContext();
		Map<String,AtomicLong> map = new HashMap<String,AtomicLong>();
		map.put("Enrichment", new AtomicLong(121212) );
		jobContext.put(ETLConstants.TIMER, map);		
		jobExecution.setExecutionContext(jobContext);
		jobExecution.getExecutionContext().putString(ETLConstants.FILE_READER, "csvReader");
		stepExecution = new StepExecution("suppDataProcessStep", jobExecution);
		ExecutionContext executionContext = new ExecutionContext();	
		executionContext.put(ETLConstants.AGGREGATION_READ_COUNT, new AtomicLong(0));
		executionContext.put("partitionId", "P1");
		executionContext.put(
				ETLConstants.AGGREGATION_SKIPPED_COUNT,
				new AtomicLong(0));
		stepExecution.setExecutionContext(executionContext);
		
		modelObj = new SupplementaryDataRecord();		
		ExecutionContext context = stepExecution.getExecutionContext();
		context.put(ETLConstants.AGGREGATION_READ_COUNT, new AtomicLong(0));
		context.put("partitionId", 100);
		aggregationProcessor.setCurrentExecutionContext(context);
		aggregationProcessor
				.setAggregationServiceFactory(aggregationServiceFactory);
		aggregationProcessor.setAccountTraceabilityRequired(false);
		TimeTracker timeTracker = new TimeTracker();
		timeTracker.initTimer(stepExecution, "");
		aggregationProcessor.setTimeTracker(timeTracker);
		aggregationProcessor.setSysProcId(19);
		aggregationProcessor.setStepName("suppDataProcessStep");
		
		System.setProperty("metrics","true"); 		
		List<AggregationType> list = new ArrayList<AggregationType>();		
		list.add(getAggregationType());
		Mockito.when(this.aggregationRulesLookup.getAggregationRule(Mockito.anyList())).thenReturn(list);
		Map<String, AggregationSqlRef> aggrigationMap = new HashMap<String, AggregationSqlRef>();
		AggregationSqlRef aggregationSqlRef = new AggregationSqlRef();
		aggregationSqlRef.setAggregationId(19);
		aggregationSqlRef.setAggregationName("SUPPLEMENTARY_STG_OUTPUT");
		aggregationSqlRef.setInsertSql("INSERT into RRD_RPT_OUTPUT (BATCH_INST_ID,AGGR_RULE_ID,SYS_PROC_ID, RGN_ID, CNTRY_CD, BSUNIT_ID, PROD_TYP_BND_ID,RPT_PRD,SUBMT_ID,PROC_UNIT_ID,D_GROSS_CONTRACTUAL_CO, D_PURC_IMPR_FAIR_VAL_ADJ, D_AUTO_LEAS_RPTD_14Q, D_NON_AUTO_LEAS_RPTD_14Q, D_NON_PURP_SEC_LOAN_RPTD_BHCK, D_SME_CORP_CRD_LOAN_RPTD_US, D_SME_CORP_CRD_LOAN_RPTD_NONU, D_SME_CORP_CRD_CONS_LOAN_RPTD, D_SME_CORP_CRD_LOAN_OTH_REV_R,EFF_DT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSTIMESTAMP)");
		aggrigationMap.put("19",aggregationSqlRef);		
		Mockito.when(this.aggregationSqlLookup.getAggregationSql(Mockito.anyList())).thenReturn(aggrigationMap);
		aggregationProcessor.setBatchInstanceId(19l);
		aggregationProcessor.init();	
		
	*/}

	@Test
	public void beforeStepWithoutPresetCountTest() {
		aggregationProcessor.beforeStep(stepExecution);
		Assert.assertEquals(0,
				((AtomicLong) aggregationProcessor.getCurrentExecutionContext()
						.get(ETLConstants.AGGREGATION_READ_COUNT)).intValue());
	}

	@Test
	public void beforeStepWithPresetCountTest() {
		aggregationProcessor.beforeStep(stepExecution);
		Assert.assertEquals(0,
				((AtomicLong) aggregationProcessor.getCurrentExecutionContext()
						.get(ETLConstants.AGGREGATION_READ_COUNT)).intValue());
	}

	@Test
	public void processTest() throws Exception {
		aggregationProcessor.beforeStep(stepExecution);
		Assert.assertNotNull(aggregationProcessor.process(modelObj));
		aggregationProcessor.afterStep(stepExecution);
	}

	@Test(expected = OptimaRetailApplicationException.class)
	public void processErrorTest() throws Exception {
		aggregationProcessor.beforeStep(stepExecution);
		aggregationProcessor.process(null);
	}

	@Test
	public void processCountTest() throws Exception {
		aggregationProcessor.beforeStep(stepExecution);
		aggregationProcessor.process(modelObj);
		aggregationProcessor.process(modelObj);
		aggregationProcessor.process(modelObj);
		Assert.assertEquals(3,
				((AtomicLong) aggregationProcessor.getCurrentExecutionContext()
						.get(ETLConstants.AGGREGATION_PROCESSED_COUNT))
						.intValue());
		aggregationProcessor.afterStep(stepExecution);
	}

	@Test
	public void skipCountTest() throws Exception {
		aggregationProcessor.beforeStep(stepExecution);
		aggregationProcessor.process(modelObj);
		aggregationProcessor.process(modelObj);
		try {
			aggregationProcessor.process(null);
		} catch (OptimaRetailApplicationException e) {
			// e.printStackTrace();
		}
		Assert.assertEquals(1,
				((AtomicLong) aggregationProcessor.getCurrentExecutionContext()
						.get(ETLConstants.AGGREGATION_SKIPPED_COUNT))
						.intValue());
		aggregationProcessor.afterStep(stepExecution);
	}

	@Test
	public void processingUnitTest() throws Exception {
		aggregationProcessor.setProcessingUnitIdsString("19");
		aggregationProcessor.setStepName("step1");
		Assert.assertNotNull(aggregationProcessor.getProcessingUnitIdsString());
		Assert.assertNotNull(aggregationProcessor.getStepName());
		Assert.assertFalse(aggregationProcessor.isAccountTraceabilityRequired());

	}

	private AggregationType getAggregationType() {
		List<String> keyList= new ArrayList<String>();
		keyList.add("eRegionId");
		keyList.add("country");
		keyList.add("eBusinessUnitId");		
		keyList.add("eProductId");
		keyList.add("rptPeriod");
		keyList.add("submitterId");
		keyList.add("processingUnit");
		List<String> keyValues= new ArrayList<String>();
		keyValues.add("cumLifeGrossChargeOffAmt");
		keyValues.add("cumLifePurcImprFairValAdj");
		keyValues.add("autoLeaseRepY14QSch");
		keyValues.add("nonAutoLeaseRepY14QSch");
		keyValues.add("nonPurSecBasLoaRep");
		keyValues.add("smeCorpCardLoaRepComIndUs");
		keyValues.add("smeCorpCardLoaRepComIndOutUs");
		keyValues.add("smeCorpCardLoaIndFamOtCard");
		keyValues.add("smeCorpCardLoaIndFamOthers");		
		AggregationType aggregationType = new AggregationType();
		aggregationType.setId(19l);		
		aggregationType.setAggregationRuleKeySpelExpr(keyList);
		aggregationType.setColumnsToAggregateValueSpelExpr(keyValues);
		aggregationType.setWhereCriteriaSpelExpr("supplSkipRecord");
		aggregationType.setProcessingUnitId(19);
		aggregationType.setName("suppDataProcessStep");
		return aggregationType;
		
	}
	
}
