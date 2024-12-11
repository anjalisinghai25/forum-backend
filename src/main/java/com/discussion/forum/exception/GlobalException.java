package com.discussion.forum.exception;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException {
    private String message;
    private Integer code;

    public GlobalException() {
    }

    public GlobalException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public GlobalException(String message) {
        this.message = message != null ? message : "Internal Server Error !";
    }

    public GlobalException(Exception e) {
        this.message = e.getLocalizedMessage() != null ? e.getLocalizedMessage() : "Internal Server Error !";
        this.code = 500;
    }
}
