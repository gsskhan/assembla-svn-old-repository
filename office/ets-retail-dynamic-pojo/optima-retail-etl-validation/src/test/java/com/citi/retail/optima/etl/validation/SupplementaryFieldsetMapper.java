package com.citi.retail.optima.etl.validation;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.citi.retail.optima.etl.validation.model.SupplementaryDataRecord;

public class SupplementaryFieldsetMapper implements
		FieldSetMapper<SupplementaryDataRecord> {

	public SupplementaryDataRecord mapFieldSet(FieldSet fieldSet)
			throws BindException {

		SupplementaryDataRecord record = new SupplementaryDataRecord();

		record.setRptPeriod(fieldSet.readInt(0));
		record.setRegionId(fieldSet.readInt(1));
		record.setCountry(fieldSet.readString(2));
		record.setBusinessUnit(fieldSet.readString(3));
		record.setProductType(fieldSet.readString(4));
		record.setCumLifeGrossChargeOffAmt(readDouble(5, fieldSet));
		record.setCumLifePurcImprFairValAdj(readDouble(6, fieldSet));
		record.setAutoLeaseRepY14QSch(readDouble(7, fieldSet));
		record.setNonAutoLeaseRepY14QSch(readDouble(8, fieldSet));
		record.setNonPurSecBasLoaRep(readDouble(9, fieldSet));
		record.setSmeCorpCardLoaRepComIndUs(readDouble(10, fieldSet));
		record.setSmeCorpCardLoaRepComIndOutUs(readDouble(11, fieldSet));
		record.setSmeCorpCardLoaIndFamOtCard(readDouble(12, fieldSet));
		record.setSmeCorpCardLoaIndFamOthers(readDouble(13, fieldSet));
		record.setSubmitterId(fieldSet.readString(14));
		return record;
	}

	private Double readDouble(int i, FieldSet fieldSet) {
		if (fieldSet.readString(i) != null
				&& fieldSet.readString(i).length() != 0) {
			return fieldSet.readDouble(i);
		}
		return null;
	}

}
