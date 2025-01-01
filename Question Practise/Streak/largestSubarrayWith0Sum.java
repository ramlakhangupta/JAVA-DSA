import java.util.HashMap;
public class largestSubarrayWith0Sum {
   public static int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0; 
        int prefixSum = 0; 
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                maxLength = i + 1;
            }
            if (map.containsKey(prefixSum)) {         
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        int n = 8;
        System.out.println(maxLen(arr, n));
    }
}
