package com.knoldus.java;

import scala.Int;

public class CurrentThread {
    public static void main(String[] args) {
        Thread currentThread =  Thread.currentThread();

        System.out.println("The Current thread is  "+ currentThread);

        MyThread1 mt = new MyThread1();
        mt.setName("MyThread1");
        MyThread1 mt2 = new MyThread1();
        mt2.setName("MyThread2");

        System.out.println("Thread State of MyThread1 before calling start: "+mt.getState());
        mt.start();
        mt2.start();
        System.out.println("Thread State of MyThread1 in Main method before Sleep: " + mt.getState());
        System.out.println("Thread State of MyThread2 in Main method before Sleep: " + mt2.getState());

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {}
        System.out.println("Thread State of MyThread1 in Main method after Sleep: " + mt.getState());
        System.out.println("Thread State of MyThread2 in Main method after Sleep: " + mt2.getState());





    }
}


class MyThread1 extends Thread {

    public void run(){
        System.out.println("Run by "+ Thread.currentThread().getName());

        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {}

        System.out.println("Thread State of: "+ Thread.currentThread().getName()+ " - "+Thread.currentThread().getState());
        System.out.println("Exit of Thread: " + Thread.currentThread().getName());
    }
}