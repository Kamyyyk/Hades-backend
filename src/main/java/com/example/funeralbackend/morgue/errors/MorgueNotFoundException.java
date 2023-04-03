package com.example.funeralbackend.morgue.errors;

public class MorgueNotFoundException extends RuntimeException {
    public MorgueNotFoundException() {
    }

    public MorgueNotFoundException(String message) {
        super(message);
    }

    public MorgueNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MorgueNotFoundException(Throwable cause) {
        super(cause);
    }

    public MorgueNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
