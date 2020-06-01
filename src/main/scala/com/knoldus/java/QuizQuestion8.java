package com.knoldus.java;

public class QuizQuestion8 {
}

class MyThread8 extends Thread
{
    public static void main(String [] args)
    {
        MyThread8 t = new MyThread8(); /* Line 5 */
        t.run();  /* Line 6 */
    }

    public void run()
    {
        for(int i=1; i < 3; ++i)
        {
            System.out.print(i + "..");
        }
    }
}