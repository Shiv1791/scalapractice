public class FindParent {
    static class Node {
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static void findParent(Node root, int nodeData, int parent){

        if(root == null)
            return;
        if(root.data == nodeData) {
            System.out.println(parent);
        }
        else {
            findParent(root.left,nodeData,root.data);
            findParent(root.right,nodeData,root.data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);

        int node = 7;
        findParent(root, node, -1);
    }

}
