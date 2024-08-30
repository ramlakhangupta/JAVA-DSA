
import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallestNo {

    public static void main(String[] args) {
        int[] n = {2,10,-2,-4,5,7,3};
        int k = 3;
        System.out.println(kthSmallByMaxHeap(n,k));
    }


    //YE WASTE OF TIME H ISKI BHI TC O(nlogn) lagega + extra space O(n) lagega 
    private static int kthSmallByMinHeap(int[] n, int k) {
        //Min HEAP create hota h by default
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n.length; i++) {
            pq.add(n[i]);
        }
        for (int i = 0; i < k-1; i++) {
            pq.remove();
        }
        return pq.peek();
    }



    //OPTIMIZE BY HEAP 
    //WE Use MAX-Heap
    public static int kthSmallByMaxHeap(int[] n, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n.length; i++) {
            pq.add(n[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
      return pq.peek();
    }
}