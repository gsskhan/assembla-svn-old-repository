/**
 * 
 */
package com.citi.retail.optima.etl.common.model.subaccount.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.citi.retail.optima.etl.common.model.subaccount.RiskMitigantSubTypeRelationship;

/**
 * @author hs73849
 * 
 */
public class RiskMitigantSubTypeRelationshipTest {

	private RiskMitigantSubTypeRelationship acct;

	@Before
	public void setUp() {
		acct = new RiskMitigantSubTypeRelationship();
	}

	@Test
	public void testRiskMitigationSubtype() {
		this.acct.setAccountNumber("12345");
		Assert.assertEquals("12345",
				this.acct.getAccountNumber());

		this.acct.setPortfolioId("CA_OC1");
		Assert.assertEquals("CA_OC1",
				this.acct.getPortfolioId());

		this.acct
				.setRiskMitigationSubtype("Collateral-finance");
		Assert.assertEquals("Collateral-finance",
				this.acct.getRiskMitigationSubtype());

		Date dd = new Date(new Date().getTime());
		this.acct.setInsuranceEffectiveDate(dd);
		Assert.assertEquals(dd, this.acct
				.getInsuranceEffectiveDate());

		this.acct.setInsuranceExpirationDate(dd);
		Assert.assertEquals(dd, this.acct
				.getInsuranceExpirationDate());

		this.acct
				.setLatestCollateralValue(new Double(12.13));
		Assert.assertEquals(new Double(12.13),
				this.acct
						.getLatestCollateralValue());

		this.acct
				.setOriginalCollateralValue(new Double(12.13));
		Assert.assertEquals(new Double(12.13),
				this.acct
						.getOriginalCollateralValue());

		this.acct.setGuaranteeAmount(new Double(
				12.13));
		Assert.assertEquals(new Double(12.13),
				this.acct.getGuaranteeAmount());

		this.acct
				.setInsuranceCoverageBasis("Fixed");
		Assert.assertEquals("Fixed", this.acct
				.getInsuranceCoverageBasis());

		this.acct
				.setInsuranceCoveragePercent(new Double(12.13));
		Assert.assertEquals(new Double(12.13),
				this.acct
						.getInsuranceCoveragePercent());

		this.acct
				.setInsuranceFixedAmount(new Double(12.13));
		Assert.assertEquals(new Double(12.13),
				this.acct
						.getInsuranceFixedAmount());
	}
}
