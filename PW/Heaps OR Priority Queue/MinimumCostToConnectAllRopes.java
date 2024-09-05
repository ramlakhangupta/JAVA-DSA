import java.util.PriorityQueue;

public class MinimumCostToConnectAllRopes {
    public static long minCost(long[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : arr) {
            pq.add( num);
        }

        int cost = 0;
        while (pq.size() > 1) {
            long x = pq.remove();
            long y = pq.remove();
            cost += x + y;
            pq.add(x+y);
           
        }
       return cost;

    }

    public static void main(String[] args) {
        long[] arr = {4,3,2,6};
        System.out.println(minCost(arr)); 
    }
}
