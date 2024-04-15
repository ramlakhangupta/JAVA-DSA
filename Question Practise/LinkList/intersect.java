public class intersect {
    public class ListNode {
      int val;
    ListNode next;
      ListNode(int x) {
        val = x;
          next = null;
      }
  }
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int count1 = 0;
        
        while(temp1 != null){
           
            count1++;
             temp1 = temp1.next;
        }
        int count2 = 0;
        while(temp2 != null){
          
            count2++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;
        if(count1 > count2){
            int size = count1 - count2;
           for(int i = 1; i <= size ; i++){
            temp1 = temp1.next;
           }
        } else {
            int size = count2 - count1;
              for(int i = 1; i <= size ; i++){
                temp2 = temp2.next;
           }
        }

        
        while(temp1 != temp2 ){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        
        return temp1;
    }
}
}
