import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.{Executor, ExecutorService, Executors}
//First
object ThreadPractice1JavaOperation extends Thread {

  def main(args: Array[String]): Unit = {
    val threadPool = Executors.newFixedThreadPool(2)
    val t1 = threadPool.submit{
      new Thread{
        while(!Thread.currentThread().isInterrupted){
          //performs the next steps
          println("Stopping task is requested")
        }
      }
    }

    t1.cancel(true)


    //OR
    threadPool.submit{
      new Thread{
        while (!Thread.currentThread().isInterrupted){
        }
      }

    }

  }
}

//Second
object ThreadPractice2JavaOperation {
  private class MyTask extends Runnable {
    @volatile var keepRunning = true
              var keepRunning2 = new AtomicBoolean(true)// Almost works same as volatile
    override def run(): Unit = {
      while (keepRunning){

      }
    }
  }


  def process:Unit = {
     val myTask = new MyTask
    val t1 = new Thread(myTask)
    t1.start()

    try {
      Thread.sleep(10*60*1000)
    } catch {
      case x:InterruptedException=>x
      case _ => throw new SecurityException("it waits to long")
    }

    val service = Executors.newScheduledThreadPool(1)
/*    service.schedule{myTask
    }*/
    myTask.keepRunning = false

  }


}

//Third IO Operations
object ThreadPractice3IoOperation {

  private class MyTask extends Runnable {
    var keepRunning = new AtomicBoolean(true)

    override def run(): Unit = {
      while(keepRunning.get()) {
     // call the database operation
        //jdbc.storeProcedureCall
        // and assume it stuck here for more than 10 mins  so it never to return a while to check
        //if there is and interrupt of valatile change

        // there is one more method
        //httpClient.request()
        //they(httpClient and jdbc library) have these time out method
      }
    }

    def stop = {
      keepRunning.set(false)
    }
  }

}

object  ThreadPractice4CreateMultipleThreads  extends Thread{

  val service = Executors.newFixedThreadPool(100)
  def main(args: Array[String]): Unit = {
    for(i<-1 to 100){
      service.execute(new IOTask)
    }
  }

  class IOTask extends Runnable{
    override def run(): Unit = ???
  }
}