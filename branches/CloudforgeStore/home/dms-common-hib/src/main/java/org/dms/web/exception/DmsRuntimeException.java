package org.dms.web.exception;

public class DmsRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -6440566610835526153L;
	
	public DmsRuntimeException() {
		super();
	}
	
	public DmsRuntimeException(String reason) {
		super(reason);
	}

}
