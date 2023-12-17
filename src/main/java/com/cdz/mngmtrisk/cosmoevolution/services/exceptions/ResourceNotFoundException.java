package com.cdz.mngmtrisk.cosmoevolution.services.exceptions;

/**
 * RuntimeException não exige o bloco try...catch
 * diferento do Exception que exige o bloco try...catch
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg) {

        super(msg);
    }
}
