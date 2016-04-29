//package com.citi.optima.retail.batch.preprocess;
//
//import java.util.Map;
//
//
//	public class TwMortgagesPreProcessDataProviderImpl<T> implements TwMortgagesPreProcessorDataProvider<T> {
//
//		private Map<String, T> preprocessMap;
////		private ConcurrentHashMap<String, BauimpRecord> preprocessBauimpMap;
////		private ConcurrentHashMap<String, MortgageTdrRecord> preprocessTdrMap;
////		private ConcurrentHashMap<String, FicoRecord> preprocessFicoMap;
////		private ConcurrentHashMap<String, MutColRecord> preprocessMutColMap;
////		private ConcurrentHashMap<String, FipRecord> preprocessFipMap;
////		private ConcurrentHashMap<String, OreoRecord> preprocessOreoMap;
////		private ConcurrentHashMap<String, MemoRecord> preprocessMemoMap;
////		private ConcurrentHashMap<String, TeaserRateRecord> preprocessTeaserRateMap;
////		
////		@Override
////		public T getValue(String key) {
////			return preprocessMap.get(key);
////		}
////		
//		@Override
//		public void setPreprocessMap(Map<String, T> preprocessMap) {
//			this.preprocessMap = preprocessMap;
//		}
//		
//		@Override
//		public Map<String, T> getPreprocessMap() {
//			return preprocessMap;
//		}
//		
//		@Override
//		public Integer getFicoAlignScore(String cardNumber) {
//			FicoRecord ficoRecord = preprocessFicoMap.get(cardNumber);
//		
//			return ficoRecord != null?ficoRecord.getAlignScore():null;
//		}
//		
//		
//		@Override
//		public String getTdrFlag(String cardNumber) {
//			
//			MortgageTdrRecord tdrRecord = preprocessTdrMap.get(cardNumber);
//		
//			return tdrRecord != null ? tdrRecord.getTdr():null;
//		}
//		
//		
//		@Override
//		public Date getTdrUpdateDate(String cardNumber) {
//			MortgageTdrRecord tdrRecord = preprocessTdrMap.get(cardNumber);
//		
//			return tdrRecord != null ? tdrRecord.getxBookDate():null;
//		}
//		
//		@Override
//		public boolean isAvailableAtTdr(String cardNumber) {
//			return preprocessTdrMap.containsKey(cardNumber);
//		}
//		
////	
////		
////
////		@Override
////		public boolean isAvailableAtBauimp(String cardNumber) {
////			return preprocessBauimpMap.containsKey(cardNumber);
////		}
////
////		@Override
////		public String getBauimpFlag(String cardNumber) {
////			BauimpRecord bauimpRecord = preprocessBauimpMap.get(cardNumber);
////			return bauimpRecord != null ? bauimpRecord.getBauimpFlag():null;
////		}
////
////		@Override
////		public boolean isAvailableAtFip(String cardNumber) {
////			
////			return preprocessFipMap.containsKey(cardNumber);
////		}
////
////		@Override
////		public String getFipKeepFlag(String cardNumber) {
////			FipRecord fipRecord = preprocessFipMap.get(cardNumber);
////			return fipRecord != null ? fipRecord.getKeepFlag():null;
////		}
////
////		@Override
////		public String getFipStateNow(String cardNumber) {
////			FipRecord fipRecord = preprocessFipMap.get(cardNumber);
////			return fipRecord != null ? fipRecord.getStateNow():null;
////		}
////
////		@Override
////		public boolean isAvailableAtMemo(String cardNumber) {
////			return preprocessMemoMap.containsKey(cardNumber);
////		}
////
////		@Override
////		public Double getMemoGlgwo(String cardNumber) {
////			MemoRecord memoRecord = preprocessMemoMap.get(cardNumber);
////			return memoRecord != null ? memoRecord.getGlgwo():null;
////		}
////
////		@Override
////		public Double getMemoBankruptcy(String cardNumber) {
////			MemoRecord memoRecord = preprocessMemoMap.get(cardNumber);
////			return memoRecord != null ? memoRecord.getBankruptcy():null;
////		}
////
////		@Override
////		public Double getMemoGlrec(String cardNumber) {
////			MemoRecord memoRecord = preprocessMemoMap.get(cardNumber);
////			return memoRecord != null ? memoRecord.getGlrec():null;
////		}
////
////		@Override
////		public boolean isAvailableAtMutCol(String cardNumber) {
////			return preprocessMutColMap.containsKey(cardNumber);
////		}
////
////		@Override
////		public Double getMutColOrgGav(String cardNumber) {
////			MutColRecord mutColRecord = preprocessMutColMap.get(cardNumber);
////			return mutColRecord != null ? mutColRecord.getOrgGav():null;
////		}
////
////		@Override
////		public boolean isAvailableAtOreo(String cardNumber) {
////			return preprocessOreoMap.containsKey(cardNumber);
////		}
////
////		@Override
////		public String getOreoStatus(String cardNumber) {
////			OreoRecord oreoRecord = preprocessOreoMap.get(cardNumber);
////			return oreoRecord != null ? oreoRecord.getStatus():null;
////		}
////
////		@Override
////		public Double getOreoOrigBookValue(String cardNumber) {
////			OreoRecord oreoRecord = preprocessOreoMap.get(cardNumber);
////			return oreoRecord != null ? oreoRecord.getOrigBookValue():null;
////		}
////
////		@Override
////		public Double getOreoNetBookValue(String cardNumber) {
////			OreoRecord oreoRecord = preprocessOreoMap.get(cardNumber);
////			return oreoRecord != null ? oreoRecord.getNetBookValue():null;
////		}
////
////		@Override
////		public boolean isAvailableAtTeaserRate(String cardNumber) {
////			return preprocessTeaserRateMap.containsKey(cardNumber);
////		}
////
////		@Override
////		public String getTeaserRateFlag(String cardNumber) {
////			TeaserRateRecord teaserRateRecord = preprocessTeaserRateMap.get(cardNumber);
////			return teaserRateRecord != null ? teaserRateRecord.getTeaserRateFlag():null;
////		}
////		
////		
////		/**
////		 * @return the preprocessBauimpMap
////		 */
////		public ConcurrentHashMap<String, BauimpRecord> getPreprocessBauimpMap() {
////			return preprocessBauimpMap;
////		}
////
////		/**
////		 * @param preprocessBauimpMap the preprocessBauimpMap to set
////		 */
////		public void setPreprocessBauimpMap(
////				ConcurrentHashMap<String, BauimpRecord> preprocessBauimpMap) {
////			this.preprocessBauimpMap = preprocessBauimpMap;
////		}
////
////		/**
////		 * @return the preprocessTdrMap
////		 */
////		public ConcurrentHashMap<String, MortgageTdrRecord> getPreprocessTdrMap() {
////			return preprocessTdrMap;
////		}
////
////		/**
////		 * @param preprocessTdrMap the preprocessTdrMap to set
////		 */
////		public void setPreprocessTdrMap(
////				ConcurrentHashMap<String, MortgageTdrRecord> preprocessTdrMap) {
////			this.preprocessTdrMap = preprocessTdrMap;
////		}
////
////		/**
////		 * @return the preprocessFicoMap
////		 */
////		public ConcurrentHashMap<String, FicoRecord> getPreprocessFicoMap() {
////			return preprocessFicoMap;
////		}
////
////		/**
////		 * @param preprocessFicoMap the preprocessFicoMap to set
////		 */
////		public void setPreprocessFicoMap(
////				ConcurrentHashMap<String, FicoRecord> preprocessFicoMap) {
////			this.preprocessFicoMap = preprocessFicoMap;
////		}
////
////		/**
////		 * @return the preprocessMutColMap
////		 */
////		public ConcurrentHashMap<String, MutColRecord> getPreprocessMutColMap() {
////			return preprocessMutColMap;
////		}
////
////		/**
////		 * @param preprocessMutColMap the preprocessMutColMap to set
////		 */
////		public void setPreprocessMutColMap(
////				ConcurrentHashMap<String, MutColRecord> preprocessMutColMap) {
////			this.preprocessMutColMap = preprocessMutColMap;
////		}
////
////		/**
////		 * @return the preprocessFipMap
////		 */
////		public ConcurrentHashMap<String, FipRecord> getPreprocessFipMap() {
////			return preprocessFipMap;
////		}
////
////		/**
////		 * @param preprocessFipMap the preprocessFipMap to set
////		 */
////		public void setPreprocessFipMap(
////				ConcurrentHashMap<String, FipRecord> preprocessFipMap) {
////			this.preprocessFipMap = preprocessFipMap;
////		}
////
////		/**
////		 * @return the preprocessOreoMap
////		 */
////		public ConcurrentHashMap<String, OreoRecord> getPreprocessOreoMap() {
////			return preprocessOreoMap;
////		}
////
////		/**
////		 * @param preprocessOreoMap the preprocessOreoMap to set
////		 */
////		public void setPreprocessOreoMap(
////				ConcurrentHashMap<String, OreoRecord> preprocessOreoMap) {
////			this.preprocessOreoMap = preprocessOreoMap;
////		}
////
////		/**
////		 * @return the preprocessMemoMap
////		 */
////		public ConcurrentHashMap<String, MemoRecord> getPreprocessMemoMap() {
////			return preprocessMemoMap;
////		}
////
////		/**
////		 * @param preprocessMemoMap the preprocessMemoMap to set
////		 */
////		public void setPreprocessMemoMap(
////				ConcurrentHashMap<String, MemoRecord> preprocessMemoMap) {
////			this.preprocessMemoMap = preprocessMemoMap;
////		}
////
////		/**
////		 * @return the preprocessTeaserRateMap
////		 */
////		public ConcurrentHashMap<String, TeaserRateRecord> getPreprocessTeaserRateMap() {
////			return preprocessTeaserRateMap;
////		}
////
////		/**
////		 * @param preprocessTeaserRateMap the preprocessTeaserRateMap to set
////		 */
////		public void setPreprocessTeaserRateMap(
////				ConcurrentHashMap<String, TeaserRateRecord> preprocessTeaserRateMap) {
////			this.preprocessTeaserRateMap = preprocessTeaserRateMap;
////		}
//		
//		
//		
//		
//
//}