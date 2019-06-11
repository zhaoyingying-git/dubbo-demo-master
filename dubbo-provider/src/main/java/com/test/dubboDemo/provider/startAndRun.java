package com.test.dubboDemo.provider;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * run()相当于线程的任务处理逻辑的入口方法
 * start()的作用是启动相应的线程
 * @author yiRain
 *
 */
public class startAndRun {
    public static void  main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                world();
            }
        };
        t.start();
        t.run();
        System.out.print(" Hello ");
    }

    static void world(){
        System.out.print(" world ");
    }

}