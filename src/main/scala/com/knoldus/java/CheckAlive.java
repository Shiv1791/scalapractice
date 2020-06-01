package com.knoldus.java;

import scala.collection.immutable.$colon$colon;

public class CheckAlive {

    public static void main(String[] args) {
        MyThread obj = new MyThread();
        obj.setDaemon(true);
        obj.start();
        while (obj.isAlive()){
            try {
                obj.join();
                //obj.sleep(10000);
            }
            catch (InterruptedException e){
                System.out.println("Sleeping thread interrupted");
            }
            System.out.println(" Thread-sleep Demo complete ");
        }
    }
}


/*
class MyThread1 extends Thread {

    public void run(){
        System.out.println("My thread is in running state");
        System.out.println ("Daemon is " + isDaemon ());
    }
}*/
