import java.util.*;

public  class DeleteNodeFromLinkedListPresentInArray3217 {
    public static class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

         public static  ListNode modifiedList(int[] nums, ListNode head) {
            if (head == null) {
                return null;
            }
            
            // Step 1: Add all elements of nums[] into a set for O(1) lookup.
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
        
            // Step 2: Create a dummy node to simplify the deletion process.
            ListNode dummy = new ListNode(0); // Dummy node
            dummy.next = head; // Link dummy to the head
            ListNode current = dummy; // Current pointer to traverse
        
            // Step 3: Traverse the list and remove nodes that are in the set.
            while (current.next != null) {
                if (set.contains(current.next.val)) {
                    // If the next node's value is in the set, skip it.
                    current.next = current.next.next;
                } else {
                    // Otherwise, move to the next node.
                    current = current.next;
                }
            }
        
            // Step 4: Return the new head (which is the next of dummy node).
            return dummy.next;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2))))));
            int[] nums = {1};
            
            ListNode result = modifiedList(nums, head);
            
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            }
            // Output: 1 4
        }
}
