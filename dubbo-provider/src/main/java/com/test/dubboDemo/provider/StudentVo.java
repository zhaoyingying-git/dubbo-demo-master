package com.test.dubboDemo.provider;


public class StudentVo {
    private Integer id;
    private String sName;
    private String sPwd;
    private String sAddress;
    private String a;
    private String b;
    private String c;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }
    public String getsPwd() {
        return sPwd;
    }
    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }
    public String getsAddress() {
        return sAddress;
    }
    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
