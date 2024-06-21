package com.devsuperior.demo.dto;

import java.time.Instant;

public class CustomError {
    private Instant timestamp;
    private String error;
    private Integer status;
    private String path;

    public CustomError(Instant timestamp, String error, Integer status, String path) {
        this.timestamp = timestamp;
        this.error = error;
        this.status = status;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public Integer getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }
}
