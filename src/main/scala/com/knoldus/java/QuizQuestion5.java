package com.knoldus.java;

public class QuizQuestion5 {
}

class ThreadTest1 extends Thread
{
    public void run()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println("A");
            System.out.println("B");
        }
    }
}
class ThreadDemo3 extends Thread
{
    public void run()
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println("C");
            System.out.println("D");
        }
    }
    public static void main(String args[])
    {
        ThreadTest1 t1 = new ThreadTest1();
        ThreadDemo3 t2 = new ThreadDemo3();
        t1.start();
        t2.start();
    }
}