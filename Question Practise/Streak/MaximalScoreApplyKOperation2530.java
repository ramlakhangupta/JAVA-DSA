import java.util.Collections;
import java.util.PriorityQueue;

public class MaximalScoreApplyKOperation2530 {
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            double r  = (double)nums[i];
            pq.add(r);
        }
        int i = 0;
        long ans = 0;
        while (k != 0) {
            double r = (double)pq.poll();
            ans += r;
            r = Math.ceil(r/3);
            pq.add(r);
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10,10,10,10,10};
        int k = 5;
        System.out.println(maxKelements(arr, k));
    }
}
