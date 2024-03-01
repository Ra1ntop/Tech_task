package com.tech.task_server.exception;

public class EntityAlreadyExists extends RuntimeException {
    public EntityAlreadyExists(String msg) {
        super(msg);
    }
}
