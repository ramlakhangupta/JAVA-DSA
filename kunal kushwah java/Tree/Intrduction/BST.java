import org.w3c.dom.Node;

public class BST {
    public class  node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node (int value) {
            this.value = value;
        }

        public int getValue (){
            return value;
        }
    }

    private Node root;

    public BST() {

    }

    public int height(Node node) {
        if (node == null) {
            return -1;

        }

        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }
    
    public void display() {
        display( root, "Root Node: ");
    }
    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Left child of " + node.getValue() + " : ");
    }
}
