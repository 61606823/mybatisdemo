package com.aska.mybatisdemo.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
