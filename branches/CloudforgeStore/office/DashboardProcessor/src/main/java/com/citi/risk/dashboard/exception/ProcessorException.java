package com.citi.risk.dashboard.exception;

/**
 * @author gk85985
 * 
 */
public class ProcessorException extends RuntimeException {

    private static final long serialVersionUID = -2164150750126031525L;

    public ProcessorException() {
        super();
    }

    public ProcessorException(String reason) {
        super(reason);
    }
}
