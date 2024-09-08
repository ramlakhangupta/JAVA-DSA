import java.util.*;

public class subarraySumEqualsK560 {
    public static int subarraySum1(int[] arr, int k) {
        
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j=i; j < arr.length; j++ ){
                sum += arr[j];
                if(sum == k){
                    count += 1;
                }
            }
        }
        return count;
    }

    public static int subarraySum(int[] arr, int k) {
        int count = 0;
        int n = arr.length;
        //make arr prefix sum array
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i-1]; 
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int ele = arr[i];
            if (ele == k) {
                count++;
            }
            int rem = ele - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            if (map.containsKey(ele)) {
                int freq = map.get(ele);
                map.put(ele,freq+ 1);
            } else {
                map.put(ele, 1);
            }
           
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int k = 2;
        subarraySum1(arr, k);
    }
}
