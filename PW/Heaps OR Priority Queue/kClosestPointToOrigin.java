
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class kClosestPointToOrigin {

    //METHOD NO  1 (IT GIVE ERROR FOR SOME CONDITION) !!
    public class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public  int[][] kClosest1(int[][] points, int k) {
        HashMap<Integer, Pair> map = new HashMap<>();
        //MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for (int i = 0; i < points.length; i++) {
        int x = points[i][0], y = points[i][1];
        int d2 = x*x + y*y;
        pq.add(d2);
        map.put(d2, new Pair(x, y));
        if (pq.size() > k) {
            pq.remove();
        }

       }
       int[][] ans = new int[k][2];
       for (int i = 0; i < k; i++) {
        int dist = pq.remove();
        Pair pt = map.get(dist);
        ans[i][0] = pt.x;
        ans[i][1] = pt.y;
       }
       return ans;

    }




    //METHOD NO 2 
    public class Triplet implements Comparable<Triplet>{
        int d;
        int x;
        int y;
        Triplet(int d, int x, int y){
            this.x = x;
            this.y = y;
            this.d = d;
        }
        public int compareTo(Triplet t){
            return this.d - t.d;
        }
    }


    public  int[][] kClosest(int[][] points, int k) {
       
        //MaxHeap
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            int d = x*x + y*y;
            pq.add(new Triplet(d, x, y));
           
            if (pq.size() > k) {
                pq.remove();
            }

        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            
            Triplet t = pq.remove();
            ans[i][0] = t.x;
            ans[i][1] = t.y;
        }
        return ans;

    }
} 



