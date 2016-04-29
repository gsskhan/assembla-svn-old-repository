package com.citi.retail.optima.etl.common.model.cache;

/**
 * @author sr67841 This is the Base object model that is using in caching.
 * 
 */
public class KeyRef {

	// functionName,productName and schedule will be removed. It is not removed
	// now so that build doesnt break. Only scheduleId will be used in future
	private Integer processingUnitId;
	private String segmentType;

	public KeyRef() {
	};

	public KeyRef(Integer processingUnitId, String segmentType) {
		this.processingUnitId = processingUnitId;
		this.segmentType = segmentType;
	}

	public Integer getProcessingUnitId() {
		return this.processingUnitId;
	}

	public void setProcessingUnitId(Integer processingUnitId) {
		this.processingUnitId = processingUnitId;
	}

	public String getSegmentType() {
		return this.segmentType;
	}

	public void setSegmentType(String segmentType) {
		this.segmentType = segmentType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (this.processingUnitId == null ? 0 : this.processingUnitId
						.hashCode());
		result = prime * result
				+ (this.segmentType == null ? 0 : this.segmentType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		KeyRef baseRef = (KeyRef) obj;
		if (getProcessingUnitId().equals(baseRef.getProcessingUnitId())
				&& getSegmentType().equalsIgnoreCase(baseRef.getSegmentType())) {
			return true;
		}
		return false;

	}

}
