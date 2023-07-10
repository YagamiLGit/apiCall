package com.tausifahmed.APICall.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{
    private String errorCode;
    private int status;

    public CustomException(String message, int status) {
        super(message);
        this.status = status;
    }
}
