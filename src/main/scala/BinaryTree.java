public class BinaryTree {
    Node root;
    static class Node{
        int key;
        Node left, right;

        public Node(int item){
            key = item;
            left = right =null;
        }
    }

    BinaryTree(){
        root = null;
    }

    BinaryTree(int key){
        root = new Node(key);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
    }

}
