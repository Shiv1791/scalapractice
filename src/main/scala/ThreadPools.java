/*
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

*/
/**
 * Java provides 4 types of thread Pools.
 * 1. Fixed thread Pool (CPU Bound tasks) (Blocking queue)
 * 2. Cached Thread Pool (Synchronous Queue) (kill the thread if it is ideal for 60 seconds)
 * 3. Scheduled Thread Pool (Delay Queue)
 * Single Thread Pool (blocking Queue) (Recreate the thread if thread is killed because of task)
 * *//*


*/
/*Synchronous vs Blocking queue
* SynchronousQueue is special kind of BlockingQueue in which each insert operation must wait for a
* corresponding remove operation by another thread, and vice versa.
* When you call put() method on SynchronousQueue it blocks until another thread is there to take that element out of the Queue*//*

public class ThreadPools {

    public static void main(String[] args) {
        ExecutorService executorServiceFixed = Executors.newFixedThreadPool(10);
        ExecutorService executorServiceCached = Executors.newCachedThreadPool();
        ScheduledExecutorService executorServiceScheduled = Executors.newScheduledThreadPool(8);
        ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();


        for (int i = 0; i<5; i++){
            executorServiceFixed.execute(new FixedThreadPoolTask());
            executorServiceCached.execute(new CacheThreadPoolTask());
            // task to run after every 10 seconds
            executorServiceScheduled.schedule(new ScheduledThreadPoolTask(), 10, TimeUnit.SECONDS);
            //task to run repeatedly every 10 seconds
            executorServiceScheduled.scheduleAtFixedRate(new ScheduledThreadPoolTask(), 15, 10, TimeUnit.SECONDS);
            //task run repeatedly 10 seconds after previous task complete
            executorServiceScheduled.scheduleWithFixedDelay(new ScheduledThreadPoolTask(),15,10, TimeUnit.SECONDS);
            executorServiceSingle.execute(new SingleThreadPoolTask());
        }
    }

    static class FixedThreadPoolTask implements Runnable{
        @Override
        public void run() {
            System.out.println("FixedThreadPoolTask "+ Thread.currentThread().getName());
        }
    }

    static class CacheThreadPoolTask implements Runnable{
        @Override
        public void run() {
            System.out.println("CacheThreadPoolTask "+ Thread.currentThread().getName());
        }
    }

    static class ScheduledThreadPoolTask implements Runnable{
        @Override
        public void run() {
            System.out.println("ScheduledThreadPoolTask "+ Thread.currentThread().getName());
        }
    }

    static class SingleThreadPoolTask implements Runnable{
        @Override
        public void run() {
            System.out.println("SingleThreadPoolTask "+ Thread.currentThread().getName());
        }
    }
}
*/
