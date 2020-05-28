import java.net.Inet4Address;

public class Queue {
 int front, rear, size, capacity, array[];

    Queue(int capacity){
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity-1;
        array = new int[this.capacity];
    }

    boolean isEmpty(Queue queue){
        return queue.size == 0;
    }

    boolean isFull(Queue queue){
        return queue.capacity == queue.size;
    }

    void enqueue(int item){
        if(isFull(this))
            return;
        this.rear = (this.rear+1)%this.capacity;
        this.array[this.rear] = item;
        this.size = this.size+1;
        System.out.println(item+ " enqueued to queue");
    }

    int dequeue(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front+1)%this.capacity;
        this.size = this.size-1;
        return item;
    }

    int getFront(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        return this.array[this.front];
    }

    int getRear(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        return this.array[this.rear];
    }

    public static void main(String[] args) {
        Queue queue = new Queue(100);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue.dequeue() + " dequeued item from the queue");
        System.out.println(queue.getFront() + " front item from the queue");
        System.out.println(queue.getRear() + " Rear item from the queue");
    }
}
