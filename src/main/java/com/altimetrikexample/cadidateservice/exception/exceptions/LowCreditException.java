package com.altimetrikexample.cadidateservice.exception.exceptions;

public class LowCreditException extends IllegalArgumentException {
    public LowCreditException() {
    }

    public LowCreditException(String s) {
        super(s);
    }

    public LowCreditException(String message, Throwable cause) {
        super(message, cause);
    }

    public LowCreditException(Throwable cause) {
        super(cause);
    }
}
