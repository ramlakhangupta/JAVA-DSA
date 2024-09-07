import java.util.*;
public class linkedListInBinaryTree1367 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    static  ArrayList<TreeNode> list = new ArrayList<>();     
    public static  boolean isSubPath(ListNode head, TreeNode root) {
        storeList(head,root);
        for(TreeNode elment : list){
            if (isPath(head,elment)) {
                return true;
            }
        }
        return false;
    }

    public static void storeList(ListNode head, TreeNode root){
        if (head == null || root == null) {
            return ;
        }

        if (head.val == root.val) {
            list.add(root);
        }
        storeList(head, root.left);
        storeList(head, root.right);
    }

    public static boolean isPath(ListNode head, TreeNode root){
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (head.val == root.val) {
            return isPath(head.next, root.left) || isPath(head.next, root.right);
        }
        return false;

    }

    public static void main(String[] args) {
        // Example linked list: 4 -> 2 -> 8
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(8)));
        
        // Example binary tree:
        TreeNode root = new TreeNode(1,
                          new TreeNode(4,
                               new TreeNode(2, 
                                   new TreeNode(1), 
                                   new TreeNode(6, new TreeNode(8), null)),
                               null),
                          new TreeNode(4,
                               null,
                               new TreeNode(2,
                                   new TreeNode(1), 
                                   null))
                         );

        // Check if the linked list is a subpath in the binary tree
        boolean result = isSubPath(head, root);
        System.out.println(result); // Expected output: true
    }
}
