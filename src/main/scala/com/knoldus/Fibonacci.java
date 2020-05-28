package com.knoldus;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {

    int n;
    Fibonacci(int n){this.n = n;}

    public Integer compute(){
        if(n<=1) return n;
        Fibonacci f1 = new Fibonacci(n-1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n-2);
        f2.fork();
        return f1.join() + f2.join();
    }
}
