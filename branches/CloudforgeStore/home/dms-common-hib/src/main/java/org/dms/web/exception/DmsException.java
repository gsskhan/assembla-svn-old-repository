package org.dms.web.exception;

public class DmsException extends Exception{

	private static final long serialVersionUID = 6867317612255273748L;
	
	public DmsException() {
		super();
	}
	
	public DmsException(String reason) {
		super(reason);
	}

}
