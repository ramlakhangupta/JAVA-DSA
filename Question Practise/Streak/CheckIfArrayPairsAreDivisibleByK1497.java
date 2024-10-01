import java.util.*;

public class CheckIfArrayPairsAreDivisibleByK1497 {
    public static boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++){
            int ele = arr[i]%k;
            if (ele < 0) { // if ele is negative
                ele += k;
            }
            if (map.containsKey(ele)) { 
                int freq = map.get(ele);
                map.put(ele, freq+1); 
            }
            else map.put(ele, 1);
        }
        if (map.containsKey(0)) { //for 0 elements and self divisable elements
            if (map.get(0)%2 != 0) return false;
            map.remove(0);
        }
        // if (k % 2 == 0 && map.containsKey(k/2)) {
        //     if (map.get(k/2)%2 != 0) return false;
        //     map.remove(k/2);
        // }
        for(int key : map.keySet()) {
            int rem = k - key;
            if(!map.containsKey(rem)) return false;
            int keyFreq = map.get(key);
            int remFreq = map.get(rem);
            if (keyFreq != remFreq) return false;
        }
        return true;
    
    } 

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        System.out.println(canArrange(arr, k)); // true
    }
}
