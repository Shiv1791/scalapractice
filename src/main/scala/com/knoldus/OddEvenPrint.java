package com.knoldus;


import java.util.concurrent.Semaphore;

class OddPrint1 implements Runnable {
    Semaphore one;
    Semaphore two;

    public OddPrint1(Semaphore one, Semaphore two) {
        this.one = one;
        this.two = two;
    }

    public void run() {
        for(int i = 1; i<100; i = i+2){
            try{
                one.acquire();
                System.out.println(" "+ i);
                two.release();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


class EvenPrint1 implements Runnable {

    Semaphore one;
    Semaphore two;

    public EvenPrint1(Semaphore two, Semaphore one)
    {
        this.two = two;
        this.one = one;
    }

    public void run() {
        for (int i = 2; i<100; i = i+2){
            try {
                two.acquire();
                System.out.println(" "+ i);
                one.release();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}


public class OddEvenPrint {


    public static void main(String[] args) {
        Semaphore one = new Semaphore(1);
        Semaphore two = new Semaphore(0);

        OddPrint1 printOneNumber = new OddPrint1(one, two);
        EvenPrint1 printTwoNumber = new EvenPrint1(two, one);

        new Thread(printOneNumber).start();
        new Thread(printTwoNumber).start();



    }


}

/*
class OddPrint implements Runnable{

    Semaphore one;
    Semaphore two;

    public OddPrint(Semaphore one, Semaphore two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public void run() {
        for (int i = 1;i<=100; i = i + 2) {
            try {
                one.acquire();
                System.out.println(Thread.currentThread().getName()+" -> "+ i);
                two.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenPrint implements Runnable {
    Semaphore two;
    Semaphore one;

    public EvenPrint(Semaphore two, Semaphore one) {
        this.two= two;
        this.one = one;
    }

    @Override
    public void run() {
        for (int i = 2;i<=100; i = i + 2) {
            try {
                two.acquire();
                System.out.println(Thread.currentThread().getName()+" -> "+ i);
                one.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 class NaturalNumberOddEven {

    public static void main(String[] args) {

        Semaphore one = new Semaphore(1);
        Semaphore two = new Semaphore(0);


        OddPrint printOneNumber = new OddPrint(one, two);
        EvenPrint printTwoNumber = new EvenPrint(two, one);
        new Thread(printOneNumber).start();
        new Thread(printTwoNumber).start();
    }
}

*/
