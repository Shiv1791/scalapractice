package com.knoldus.java;

public class QuizQuestion7 {
}

class MyThread6 extends Thread
{
    MyThread6() {}
    MyThread6(Runnable r) {super(r); }
    public void run()
    {
        System.out.print("Inside Thread ");
    }
}
class RunnableDemo implements Runnable
{
    public void run()
    {
        System.out.print(" Inside Runnable");
    }
}
class ThreadDemo6
{
    public static void main(String[] args)
    {
        new MyThread6().start();
        new MyThread6(new RunnableDemo()).start();
    }
}