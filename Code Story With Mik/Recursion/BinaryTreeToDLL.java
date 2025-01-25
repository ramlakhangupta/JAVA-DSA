
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}


public class BinaryTreeToDLL {
    

    Node bToDLL(Node root) {
    	//  Your code here	
    	if(root == null) {
    	    return null;
    	}
    	
    	Node head = bToDLL(root.left);
    	root.left = null;
    	
    	
    	
    	if(head != null) {
    	    Node temp = head;
    	    while(temp != null && temp.right != null){
    	        temp = temp.right;
    	    }
    	    temp.right = root;
    	    root.left = temp;
    	} else {
    	    head = root;
    	}
    	root.right = bToDLL(root.right);
    	
    	if(root.right != null ) {
    	    root.right.left = root;
    	}
    	
    	return head;
    }


}
