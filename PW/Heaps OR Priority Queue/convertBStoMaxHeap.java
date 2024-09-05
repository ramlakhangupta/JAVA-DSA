import java.util.ArrayList;
import java.util.List;

public class convertBStoMaxHeap {

    static class Node
{
    int data;
    Node left, right;
};

    static List<Integer> arr = new ArrayList<Integer>();
    static int i = 0;
    public static void convertBStoMaxHeapUtil(Node root) {
        inOrder(root);
        postOrder(root);
    }

    private static void inOrder(Node root){
        if (root == null) {
            return ;
        }
        inOrder(root.left);
        arr.add(root.data);
        inOrder(root.right);
    }
    private static void postOrder(Node root){
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        root.data = arr.get(i++);
    }

}
