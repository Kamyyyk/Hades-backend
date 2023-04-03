package com.example.funeralbackend.morgue.errors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@ToString
@Setter
public class MorgueErrorResponse {

    public MorgueErrorResponse() {
    }

    public MorgueErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    private int status;
    private String message;

    private long timeStamp;
}
