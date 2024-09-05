
class Node {
    int val;
    Node left, right;
    Node(int item) { val = item; left = right = null; }
}

public class isBstaMaxHeapOrNot {
    private static boolean isMaxHeap(Node root){
        int n = size(root);
        return isHeap(root)&&isCBT(root,0,n);
    }

    private static int size(Node root){
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    private static boolean isCBT(Node root, int i, int n){
        if (root == null) return true;
        if (i >= n) return true;
        return isCBT(root.left, 2*i+1, n) && isCBT(root.right, 2*i+2, n);
    }

    private static boolean isHeap(Node root) {
        if (root == null) return true;
        if (root.left!= null) {
            if (root.left.val>root.val) {
                return false;
            }
        }

        if (root.right!= null) {
            if (root.right.val>root.val) {
                return false;
            }
        }
        return isHeap(root.left) && isHeap(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(7);
        System.out.println(isMaxHeap(root));
        
    }
}
