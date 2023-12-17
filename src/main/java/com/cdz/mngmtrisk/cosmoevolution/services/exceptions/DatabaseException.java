package com.cdz.mngmtrisk.cosmoevolution.services.exceptions;

/**
 * RuntimeException não exige o bloco try...catch
 * diferento do Exception que exige o bloco try...catch
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg) {

        super(msg);
    }
}
