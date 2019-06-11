package com.test.dubboDemo.provider;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


 interface Person {
    public void eat();
}



 class People implements Person {
    private int a=0;
    @Override
    public void eat() {
        System.out.println("======"+a);

    }

}
 class xiaoming extends People {
    private String name;

    @Override
    public void eat() {
        System.out.println("+++++++++");
    }




public static void main(String[] args) {
        People p=new People();
        xiaoming x=new xiaoming();
        System.out.println(p instanceof Person);
        System.out.println(p instanceof xiaoming);
        System.out.println(x instanceof Person);
        System.out.println(x instanceof People);
        }
 }