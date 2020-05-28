import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class GFG {

    static class Node {
        int key;
        Vector<Node> child = new Vector<>();
        Node(int data){
            key = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", child=" + child +
                    '}';
        }
    };

    static int numberOfChildren(Node root, int x){
        int numChildren = 0 ;
        if(root == null){
            return 0;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            while(n > 0){
                Node p = q.peek();
                q.remove();
                if(p.key == x){
                    numChildren = numChildren + p.child.size();
                    return numChildren;
                }

                for (int i =0;i<p.child.size();i++)
                    q.add(p.child.get(i));
                n--;
            }
        }
        return numChildren;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        (root.child).add(new Node(2));
        (root.child).add(new Node(34));
        (root.child).add(new Node(50));
        (root.child).add(new Node(60));
        (root.child).add(new Node(70));
        (root.child.get(0).child).add(new Node(15));
        (root.child.get(0).child).add(new Node(20));
        (root.child.get(1).child).add(new Node(30));
        (root.child.get(2).child).add(new Node(40));
        (root.child.get(2).child).add(new Node(100));
        (root.child.get(2).child).add(new Node(20));
        (root.child.get(0).child.get(1).child).add(new Node(25));
        (root.child.get(0).child.get(1).child).add(new Node(50));

        int x = 2;


        System.out.println((root.child.firstElement()));
        System.out.println(root.child.get(0).child.get(1).child);
        System.out.println(root.child.get(0).child);
        System.out.println(numberOfChildren(root, x));
    }

}


