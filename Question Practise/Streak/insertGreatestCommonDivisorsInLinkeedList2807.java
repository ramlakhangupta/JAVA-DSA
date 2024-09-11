
public class insertGreatestCommonDivisorsInLinkeedList2807 {
    
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) return head;

        ListNode curr = head;
        while(curr.next != null) {
            int gc = findGCD(curr.val,curr.next.val);
            ListNode gcd = new ListNode(gc);
            gcd.next = curr.next;
            curr.next = gcd;
            curr = curr.next.next;
        }
        return head;
    }

    private int findGCD(int a, int b) {
        if ( b == 0) {
            return a;
        }

        return findGCD(b, a%b);
    }


}
