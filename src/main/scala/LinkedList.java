/* Representation of LinkedList
* Java
* */

public class LinkedList {
    Node head;

     static class Node{
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }

         @Override
         public String toString() {
             return "Node{" +
                     "data=" + data +
                     ", next=" + next +
                     '}';
         }
     }

    public void pushData(int data){
         Node newNod = new Node(data);
         newNod.next= head;
         head = newNod;
        System.out.println("head = " + newNod);
    }

    public void printList(){
         Node root = head;
        System.out.println("try to print");
         while (root!= null){
             System.out.print(root.data + " ");
             root= root.next;
         }
    }

    public void deleteElement(int position) {
        // if list is empty
        if (head == null)
            return;
        // store the head
        Node temp = head;

        //if heads needs to be removed
        if (position == 0){
            head = temp.next; //change head
            return;
    }
        //find the position of previous node
        for (int i= 0; temp != null && i< position-1; i++)
            temp = temp.next;

        //if position is more than no of nodes
        if(temp == null || temp.next == null)
            return;
        // Node root->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next = next;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.pushData(4);
        linkedList.pushData(3);

        linkedList.pushData(2);
        linkedList.pushData(1);



        /*
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        linkedList.head.next = second;
        second.next = third;
        third.next = fourth;
*/
        linkedList.printList();
        linkedList.deleteElement(6);
        linkedList.printList();

    }
}
