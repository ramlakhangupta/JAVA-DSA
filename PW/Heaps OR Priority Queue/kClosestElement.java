import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class kClosestElement {

    public class Pair implements Comparable<Pair> {
        int ele;
        int d ;
        Pair(int ele, int d){
            this.ele = ele;
            this.d = d;
        }
        public int compareTo(Pair p){
            if (this.d == p.d) {
                return this.ele - p.ele;
            }
            return this.d - p.d;
        }
        
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(arr[i],Math.abs(arr[i] - x)));
            if (pq.size() > k) {
                pq.remove();
            }
        }

        while (pq.size() > 0) {
            Pair p = pq.remove();
            list.add(p.ele);
        }
        Collections.sort(list);
        return list;
    }
}
