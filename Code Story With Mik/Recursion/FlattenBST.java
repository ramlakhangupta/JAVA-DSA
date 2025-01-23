class Node{
    int data;
    Node left, right;
    
    Node(int item) {
        data = item;
        left = right = null;
    }
}
public class FlattenBST {

  public Node flattenBST(Node root) {
        // Code here
        if(root == null ) {
            return null;
        }
        
        Node head = flattenBST(root.left);
        root.left = null;
        root.right = flattenBST(root.right);
        
        if(head != null) {
            Node temp = head;
            while(temp != null && temp.right != null ) {
                temp = temp.right;
            }
            temp.right = root;
        } else {
            head = root;
        }
        
        return 
        head;
        
    }  
} 
