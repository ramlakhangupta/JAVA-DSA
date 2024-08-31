


import java.util.HashMap;
import java.util.PriorityQueue;

public class kFrequentElement {

    public class Pair implements Comparable<Pair> {
        int ele;
        int freq;
        Pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair p) {
            return this.freq - p.freq;
        }
        
    }

    public  int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
       
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                int fre = map.get(key);
                map.put(key, fre + 1);
            }
        }
       
        for ( int ele : map.keySet()) {
            int freq = map.get(ele);
            pq.add(new Pair(ele, freq));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        for (int i = 0; i < k; i++) {
            Pair p = pq.remove();
            ans[i] = p.ele;
        }
      return ans;
    }




   
}
