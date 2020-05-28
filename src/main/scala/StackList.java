import java.util.PriorityQueue;

public class StackList {
    StackNode root;
    static class StackNode{
        int data;
        StackNode next = null;

        StackNode(int d){this.data = d;}
    }

    boolean isEmpty(){
        return root == null;
    }

    public void push(int data){
        StackNode newNode = new StackNode(data);
        if(root == null){
            root = newNode;
        }
        else{
            StackNode tmp =  root;
            root = newNode;
            newNode.next = tmp;
        }
    }

    PriorityQueue<Integer> quewerqr = new PriorityQueue<Integer>();

    int pop(){
        int popped= Integer.MAX_VALUE;
        if(root == null)
            System.out.println("Stack is empty");
        else{
            popped = root.data;
            root = root.next;
        }
        return popped;
    }


    int peek(){
        int peeked = Integer.MIN_VALUE;
        if(root == null){
            System.out.println("Stack is empty");
        }
        else {
            peeked = root.data;
        }
        return peeked;
    }


    public static void main(String[] args) {
        StackList sl = new StackList();
        System.out.println(sl.isEmpty());
        sl.push(10);
        sl.push(20);
        sl.push(30);
        sl.push(40);
        sl.push(50);

        System.out.println(sl.peek());
        System.out.println(sl.peek());
        System.out.println(sl.pop());
        System.out.println(sl.peek());
        System.out.println(sl.pop());
        System.out.println(sl.peek());
        System.out.println(sl.isEmpty());
    }
}
