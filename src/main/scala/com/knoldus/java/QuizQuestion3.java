package com.knoldus.java;

public class QuizQuestion3 {
}
 class ThreadWaitTest
{
    public static void main(String [] args)
    {
        System.out.print("1 ");
        synchronized(args)
        {
            System.out.print("2 ");
            try
            {
                args.wait(); /* Line 11 */
            }
            catch(InterruptedException e){
                System.out.println("coning");
            }
            catch (IllegalMonitorStateException e){
                System.out.println("coming IllegalMonitorStateException");
            }
        }
        System.out.print("3 ");
    }
}
