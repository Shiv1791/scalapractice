/*
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsInJava {
}

//Use case 1
class UserService {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i< 1000; i++){
            int id = i;            //Normal thread Creates
        */
/*   Thread newThread =  new Thread(()->{
                String birthDate =  new UserService().birthDate(id);
            });
            System.out.println("Threads = \n" +  newThread);
            newThread.start();*//*


        //Threads with threadPool

            threadPool.submit(()->{
                String birthDate =  new UserService().birthDate(id);
                System.out.println("THe birth   =  \n" + birthDate +"\n\n"+ id);
            });
        }
        Thread.sleep(1000);
    }

    public String birthDate(int userId) {
        Date birth = new Date(2000, 11, 21);
        //remove the dateFormate from here and make it Global
        //SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd");
        return df.format(birth);
    }
}


class ThreadSafeFormatter {
*/
/*    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){

        @Override
        protected SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-mm-dd");
        }

        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };*//*


//Or

    public static ThreadLocal<SimpleDateFormat> df =  ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-mm-dd"));
}


class UserService1 {
    public static void main(String[] args) {

    }

    public String birthDate() {
        Date birth = new Date(2000, 11, 21);
        //final SimpleDateFormat df = ThreadSafeFormatter.dateFormatThreadLocal.get();
        final SimpleDateFormat df = ThreadSafeFormatter.df.get();
        return df.format(birth);
    }
}

//Use case 2

class User {}
class UserContextHolder{
    public static ThreadLocal<User> holder = new ThreadLocal<User>();

    class Service1{
        public void process(){
        }
    }
    class Service2{
        public void process(){
        }
    }
    class Service3{
        public void process(){
        }
    }
    class Service4{
        public void process(){
            UserContextHolder.holder.remove();//last Service user no longer require
        }
    }
}


class IOTasks implements Runnable {
    @Override
    public void run() {

    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0;i<100;i++){
            executorService.execute(new IOTasks());
        }
    }
}

class MyThread extends Thread
{
    public static void main(String [] args)
    {
        MyThread t = new MyThread(); */
/* Line 5 *//*

        t.run();  */
/* Line 6 *//*

    }

    public void run()
    {
        for(int i=1; i < 3; ++i)
        {
            System.out.print(i + "..");
        }
    }
}

class ThreadDemo extends Thread
{
    public static void main(String [] args)
    {
        ThreadDemo t = new ThreadDemo();
        t.start();
        System.out.print("one. ");
        t.start();
        System.out.print("two. ");
    }
    public void run()
    {
        System.out.print("Thread ");
    }
}*/
