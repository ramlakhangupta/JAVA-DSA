import java.util.*;
public class splitLinkedListInParts725 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        ListNode res[] = new ListNode[k];
        temp = head;
        int avg = size/k;  // Integer division for average size of each part.
        int extra = size%k;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                break;
            }
            ListNode curhead = temp;
            ListNode prev = null;
            int len = 0;
            while (temp!= null && len < avg) {
                prev = temp;
                temp = temp.next;
                len++;
            }
            if (extra > 0) {
                prev = temp;
                temp = temp.next;
                extra--;
            }  
            prev.next = null;
            res[i] = curhead;
        }
        return res;

       
    }
}
