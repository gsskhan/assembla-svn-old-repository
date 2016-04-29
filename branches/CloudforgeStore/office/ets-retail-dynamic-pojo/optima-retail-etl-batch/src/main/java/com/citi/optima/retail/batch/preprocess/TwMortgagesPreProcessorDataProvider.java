package com.citi.optima.retail.batch.preprocess;

import java.util.Date;
import java.util.Map;

public interface TwMortgagesPreProcessorDataProvider<T> {

	void setPreprocessMap(Map<String, T> preprocessMap);

	T getValue(String key);

	Map<String, T> getPreprocessMap();

	Integer getFicoAlignScore(String cardNumber);
	
	String getTdrFlag(String cardNumber);

	Date getTdrUpdateDate(String cardNumber);

	boolean isAvailableAtTdr(String cardNumber);
	
	boolean isAvailableAtBauimp(String cardNumber);
	
	String getBauimpFlag(String cardNumber);
	
	boolean isAvailableAtFip(String cardNumber);
	
	String getFipKeepFlag(String cardNumber);
	
	String getFipStateNow(String cardNumber);
	
	boolean isAvailableAtMemo(String cardNumber);
	
	Double getMemoGlgwo(String cardNumber);
	
	Double getMemoBankruptcy(String cardNumber);
	
	Double getMemoGlrec(String cardNumber);
	
	boolean isAvailableAtMutCol(String cardNumber);
	
	Double getMutColOrgGav(String cardNumber);
	
	boolean isAvailableAtOreo(String cardNumber);
	
	String getOreoStatus(String cardNumber);
	
	Double getOreoOrigBookValue(String cardNumber);
	
	Double getOreoNetBookValue(String cardNumber);
	
	boolean isAvailableAtTeaserRate(String cardNumber);
	
	String getTeaserRateFlag(String cardNumber);
	
	
	
	

	
}
