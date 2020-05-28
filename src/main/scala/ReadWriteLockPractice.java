import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class ReadWriteLockPractice {


    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private  ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private  ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private void readResources() {
        readLock.lock();
        // view the resource
        System.out.println("In the read Resource");
        readLock.unlock();
    }

    private void writeResource() {
        writeLock.lock();
        // update the resource
        System.out.println("In the write  Resource");
        writeLock.unlock();
    }


    public static void main(String[] args) {
        ReadWriteLockPractice obj = new ReadWriteLockPractice();
        Thread t1 = new Thread(()-> obj.readResources());
        t1.start();
        Thread t2 = new Thread(()-> obj.readResources());
        t2.start();
        Thread t3 = new Thread(()-> obj.writeResource());
        t3.start();
        Thread t4 = new Thread(()-> obj.writeResource());
        t4.start();
    }
}


class SemaphorePractice {


        public static void main(String[] args) throws InterruptedException {
            Semaphore semaphore = new Semaphore(3);
            ExecutorService executorService = Executors.newFixedThreadPool(50);
            IntStream.of(1000).forEach(i->executorService.execute(new Tasks(/*semaphore*/)));

            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        }

    static class Tasks implements Runnable {
        Semaphore semaphore;
        @Override
        public void run(){
            semaphore.acquireUninterruptibly();
            // some processing
            //IO call to the slow service
            //rest of proressing
        semaphore.release();
        }
    }
}


class InterruptsPractice {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
    }



    static class Task implements Runnable {
        @Override
        public void run() {

        }
    }
}