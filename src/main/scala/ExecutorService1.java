import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorService1 {

    public static void main(String[] args) {
        for (int i = 0; i<100; i++){
            ExecutorService service = Executors.newFixedThreadPool(10);
         service.submit(new Task());
        }

/*        for (int i = 0; i<100; i++){
            Thread t1 = new Thread(new Task());
            t1.start();
        }*/
        System.out.println("Thread Name in main : "+ Thread.currentThread().getName());
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Name in class : "+ Thread.currentThread().getName());
        }
    }
}


//When we have CPU intensive task then we should create equal number of threads as we have the total number of cores in the CPU

class ExecutorService2{
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);
        for (int i = 0; i<100; i++){
            executorService.submit(new CPUIntensiveTask());
        }
        System.out.println("Thread Name in class : "+ Thread.currentThread().getName());
    }

    static class CPUIntensiveTask implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread Name in class : "+ Thread.currentThread().getName());
        }
    }
}