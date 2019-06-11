package com.test.dubboDemo.provider;



public class MyException extends Exception {
    public MyException(String s , String message,Object o){
        super(message);
    }
    public MyException(String message) {
        this(message, null,null);
    }
    public MyException(String message,String code) {
        this(message, code, null);
    }
}

