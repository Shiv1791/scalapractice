package com.knoldus.java;

public class ThreadExecution extends Thread {

    public void run(){
        System.out.println(" My thread is running ");
    }

    public static void main(String[] args) {
        ThreadExecution thread = new ThreadExecution();
        thread.start();
    }
}
