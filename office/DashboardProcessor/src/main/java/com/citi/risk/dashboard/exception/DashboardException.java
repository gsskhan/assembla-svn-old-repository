package com.citi.risk.dashboard.exception;

/**
 * 
 * @author gk85985 General Exception class
 */
public class DashboardException extends Exception {

    private static final long serialVersionUID = -2630142056649040826L;

    public DashboardException() {
        super();
    }

    public DashboardException(String reason) {
        super(reason);
    }
}
