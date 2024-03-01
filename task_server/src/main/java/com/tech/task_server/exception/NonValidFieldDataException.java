package com.tech.task_server.exception;

public class NonValidFieldDataException extends RuntimeException {
    public NonValidFieldDataException(String msg) {
        super(msg);
    }
}
