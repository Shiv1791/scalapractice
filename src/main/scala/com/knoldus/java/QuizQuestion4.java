package com.knoldus.java;

public class QuizQuestion4 {
}

class MyThread2 extends Thread
{
    MyThread2()
    {
        System.out.print(" MyThread");
    }
    public void run()
    {
        System.out.print(" bar");
    }
    public void run(String s)
    {
        System.out.println(" baz");
    }
}
 class ThreadDemo2
{
    public static void main (String [] args)
    {
        Thread t = new MyThread2()
        {
            public void run()
            {
                System.out.println(" foo");
            }
        };
        t.start();
    }
}