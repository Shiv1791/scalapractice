package com.knoldus.java;

public class ThreadTest extends Thread {

    public void run(){
        System.out.println("In run");
        yield();
        System.out.println("Leaving run");
    }

    public static void main(String[] args) {
        (new ThreadTest()).start();
        (new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In Second thread run");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })).start();
    }
}
