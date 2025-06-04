package com.example.app.model;

public class Result{
    boolean success;
    String message;

    public Result(boolean s, String m){
        success = s;
        message = m;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
