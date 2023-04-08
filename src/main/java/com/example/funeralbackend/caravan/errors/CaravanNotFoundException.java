package com.example.funeralbackend.caravan.errors;

public class CaravanNotFoundException extends RuntimeException {
    public CaravanNotFoundException() {
    }

    public CaravanNotFoundException(String message) {
        super(message);
    }

    public CaravanNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaravanNotFoundException(Throwable cause) {
        super(cause);
    }

    public CaravanNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
