
import java.util.ArrayList;

import java.util.HashMap;
import java.util.PriorityQueue;

public class sortArrayByIncreasingFrequency {

    public class Pair implements Comparable<Pair> {
        int ele;
        int freq;
        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }

        public int compareTo(Pair p) {
            if (this.freq == p. freq) {
                return p.ele - this.ele;
            }
            return this.freq - p.freq;
        }
        
    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {

            if (!map.containsKey(ele)) {
                map.put(ele, 1);
            } else {
                int freq = map.get(ele);
                map.put(ele, freq+1);
            }
             
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int ele : map.keySet()) {
            int freq = map.get(ele);
            pq.add(new Pair(ele, freq));
           
        }
       ArrayList<Integer>list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair p = pq.remove();
         for (int i = 0; i < p.freq; i++) {
            list.add(p.ele);
          }
        }
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    public  void main(String[] args) {
        int[] arr = {1,1,2,2,2,3};
        frequencySort(arr);
    }
}
