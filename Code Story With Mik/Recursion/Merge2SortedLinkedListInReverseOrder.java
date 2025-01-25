class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
} 


public class Merge2SortedLinkedListInReverseOrder {
    Node mergeResult(Node node1, Node node2) {
        // Your code here
        Node ans = merge(node1, node2);
        Node result = reverse(ans);
        return result ;
    }
    
    Node merge(Node l1, Node l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null ) {
            return l1;
        }
        
        Node result;
        if(l1.data < l2.data ) {
            result = l1;
            result.next = merge(l1.next, l2);
        } else {
            result = l2;
            result.next = merge(l1, l2.next);
        }
        
        return result;
    }
    
    
    Node reverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        Node rev = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return rev;
    }
}
