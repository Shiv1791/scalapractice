package com.knoldus;

import java.util.*;

public class FindChild {

    static class Node {
        int data;
        Vector<Node> child = new Vector<>();

        Node(){
            this.data = 0;
        }

        Node(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", child=" + child +
                    '}';
        }
    }


    static Node childCount(Node root, int x){
        if (root == null) {
            return root;
        }
        int countChildren = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node emptNode = new Node();

        while(!queue.isEmpty()){
            int n = queue.size();

            while (n>0){
                Node peek = queue.peek();
                queue.remove();

                assert peek != null;
                if(peek.data == x) {
                    countChildren = countChildren + peek.child.size();
                    if(countChildren == 2){
                        emptNode = peek;
                        return emptNode;
                    }

                }
                queue.addAll(peek.child);
                n--;
            }
        }
        return emptNode;
    }


    public static void main(String[] args) {
        Node root = new Node(20);
        (root.child).add(new Node(2));
        (root.child).add(new Node(34));
        (root.child).add(new Node(50));
        (root.child).add(new Node(60));
        (root.child).add(new Node(70));
        (root.child.get(0).child).add(new Node(15));
        (root.child.get(0).child).add(new Node(21));
        (root.child.get(1).child).add(new Node(30));
        (root.child.get(2).child).add(new Node(40));
        (root.child.get(2).child).add(new Node(100));
        (root.child.get(2).child).add(new Node(22));
        (root.child.get(0).child.get(1).child).add(new Node(25));
        (root.child.get(0).child.get(1).child).add(new Node(50));

        // Node whose number of
        // children is to be calculated
        int x = 21;

        // Function calling
        System.out.println(childCount(root, x));
    }
}
