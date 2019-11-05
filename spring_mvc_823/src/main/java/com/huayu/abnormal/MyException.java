package com.huayu.abnormal;

public class MyException extends Exception {
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public MyException() {
        super();

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
