package com.citi.retail.optima.etl.validation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.retail.optima.etl.validation.exception.FieldError;
import com.citi.retail.optima.etl.validation.exception.ValidationDataException;
import com.citi.retail.optima.etl.validation.exception.ValidationException;
import com.citi.retail.optima.etl.validation.model.SupplementaryDataRecord;

/**
 * 
 * @author sv16441
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/optima.retail.validation.test.xml"})
public class SupplementryValidationTest {

	List<SupplementaryDataRecord> testdata = new ArrayList<SupplementaryDataRecord>();

	@Autowired
	private DefaultLineMapper<SupplementaryDataRecord> lineMapper1;

	@Autowired
	private ValidationServiceImpl<SupplementaryDataRecord> validationService;

	@Before
	public void setUp() {
		loadData();
	}

	@Test
	public void testValidate() throws ValidationException {
		int iCount = 0;
		for (SupplementaryDataRecord record : testdata) {
			try {
				this.validationService.validate(record);

			} catch (ValidationDataException e) {
				List<FieldError> skippableList = e.getFieldErrors();
				for (FieldError eDetl : skippableList) {
					System.out.println("Row " + iCount + "= "
							+ eDetl.getAttributeName() + " ~ "
							+ eDetl.getUserErrorMessage() + " ~ "
							+ eDetl.getExceptionMessage() + " ~ ");

				}
			}
			iCount++;
		}

	}

	/**
	 * This method is used to load the data.
	 * 
	 * @throws Exception
	 */
	private void loadData() {
		Scanner scanner = new Scanner(
				ClassLoader.getSystemResourceAsStream("SupplementaryGoodFile.csv"));
		if (scanner.hasNext())
			scanner.next(); // / read header;

		while (scanner.hasNext()) {
			String lineData = scanner.next();
			try {
				SupplementaryDataRecord record = this.lineMapper1
						.mapLine(lineData, 1);
				testdata.add(record);
			} catch (Exception e) {
				// Ignore, data will not load.
			}

		}
		scanner.close();
	}
}
