package com.knoldus.java;

public class NameMyThread {

    public static void main(String[] args) {

        MyThread mt;
        if(args.length == 0){
            mt =  new MyThread();
        }
        else
            mt =  new MyThread(args[0]);

        mt.start();
    }
}

class MyThread extends Thread {


    public MyThread(){

    }

    public MyThread(String threadName) {
        setName(threadName);
    }

    public void run(){
        System.out.println("My thread is in running state");

        System.out.println("My name is : "+ getName());

        System.out.println ("Daemon is " + isDaemon ());
    }

}