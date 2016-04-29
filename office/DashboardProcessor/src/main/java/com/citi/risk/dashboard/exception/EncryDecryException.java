package com.citi.risk.dashboard.exception;

import java.util.logging.Logger;

/**
 * 
 * @author gk85985 Exception class for Encryption - decryption runtime
 *         exceptions
 */
public class EncryDecryException extends RuntimeException {

    private static final long serialVersionUID = 1930772086908965700L;
    private Logger log = Logger.getLogger(EncryDecryException.class.getName());

    public EncryDecryException() {
        log.info("Exception in encryption or decryption.");
    }

    public EncryDecryException(String reason) {
        super(reason);
        log.info("Exception in encryption or decryption - " + reason);
    }
}
