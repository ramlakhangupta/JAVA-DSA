import java.util.ArrayList;
import java.util.PriorityQueue;

public class kthSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,1,4,2,5};
        int k = 2;
        ksorted(arr, k);
    }

    private static void ksorted(int[] arr, int k) {
        int[] ans1 = new int[arr.length];
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                ans.add(pq.remove());
            }
        }
        for (int i = 0; i < k; i++) {
            ans.add(pq.remove());
        }

        for (int i = 0; i < arr.length; i++) {
            ans1[i] = ans.get(i);
            System.out.println(ans1[i]);
        }
        
    }


}
