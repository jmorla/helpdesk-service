package com.oym.helpdesk.model;

import java.time.LocalDateTime;

/**
 *
 * @author Jorge L. Morla
 * @version 1.0
 *
 *
 * The Error mapping class used to response errors status with its respective errors details
 * */
public class ErrorDTO<T> {

    private LocalDateTime timestamp;
    private String path;
    private String message;
    private String exceptionName;
    private Integer statusCode;
    private T details;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getExceptionName() {
        return exceptionName;
    }
    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }
    public Integer getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public T getDetails() {
        return details;
    }

    public void setDetails(T details) {
        this.details = details;
    }
}
