package com.test.dubboDemo.provider;


public class testException {
    public static void main(String[] args) {
        //测试
        double sum  = test();
        System.out.println(sum);
    }

    public static double test() {
        double sum = 0;
        try {
            sum = 1/0;
            System.out.println("try....");  //不执行
        }catch(ArithmeticException e) {
            System.out.println("捕获处理中....");
            return 0;
        }finally{
            System.out.println("finally....");
        }
        System.out.println("看看try/catch/finally外面的语句执不执行");
        return 3.0;
    }
}

