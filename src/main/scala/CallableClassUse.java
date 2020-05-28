import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableClassUse {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
            Future<Integer> future =  executorService.submit(new Task());
            //perform some operation
        Integer value =  future.get();//blocking operation
        System.out.println("Main Thread Name "+ Thread.currentThread().getName());

        // Now suppose we have 100 of  tasks
        List<Future> allFutures = new ArrayList<>();
        for (int i = 0; i<100;i++){
            Future<Integer> future1 = executorService.submit(new Task());
            allFutures.add(future1);
        }
        // Now we have 100 futures with 100 place holder in which none of them have value now
        //We can perform some other non related operation
        // Like say after 100 seconds there are some task got the value
        for (int i = 0; i<100;i++){
            Future<Integer> future1 = allFutures.get(i);
            try{
                Integer result = future.get(1,TimeUnit.SECONDS);
                System.out.println("the future value "+ i+ " = "+result);
                //if the ThreadPool has not start to working on the task then its good because threadpool is immediately cancel the task and it will never work
                future.cancel(false);
                //Return if task was cancelled.
                future.isCancelled();

                //true if task is completed successfully
                future.isDone();
            }
            catch (TimeoutException e){
                e.printStackTrace();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
//Please use time out methods while you are fighting with Futures like we did in above example
    }

    static class Task implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            Thread.sleep(5000);
            System.out.println("Task Thread name"+ Thread.currentThread().getName());
            return new Random().nextInt();
        }
    }
}


class GFG12321
{

    /* A binary tree node has data, pointer to
    left child and a pointer to right child */
    static class Node
    {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    };

    // Utility function to check if Binary Tree is BST
    static boolean isBSTUtil(Node root, int prev)
    {
        // traverse the tree in inorder fashion and
        // keep track of prev node
        if (root != null)
        {
            if (!isBSTUtil(root.left, prev))
                return false;

            // Allows only distinct valued nodes
            if (root.data <= prev)
                return false;

            // Initialize prev to current
            prev = root.data;

            return isBSTUtil(root.right, prev);
        }

        return true;
    }

    // Function to check if Binary Tree is BST
    static boolean isBST(Node root)
    {
        int prev = Integer.MIN_VALUE;
        return isBSTUtil(root, prev);
    }

    /* Driver code*/
    public static void main(String[] args)
    {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        if (isBST(root))
            System.out.print("Is BST");
        else
            System.out.print("Not a BST");
    }
}
