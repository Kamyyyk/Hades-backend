package com.example.funeralbackend.errors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private int status;
    private String message;
    private Long timeStamp;

    public ErrorResponse() {

    }

    public ErrorResponse(int status, String message, Long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}