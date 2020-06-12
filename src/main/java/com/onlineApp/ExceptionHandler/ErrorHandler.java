package com.onlineApp.ExceptionHandler;

public class ErrorHandler {
    private final String message;
    private String reqURI;

    public String getMessage() {
        return message;
    }

    public String getReqURI() {
        return reqURI;
    }

    public void setReqURI(String reqURI) {
        this.reqURI = reqURI;
    }

    public ErrorHandler(String message, String reqURI) {
        this.message = message;
        this.reqURI = reqURI;
    }
}
