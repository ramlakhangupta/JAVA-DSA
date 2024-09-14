public class longestSubArra2419 {
    public static int longestSubarray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxlen = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                count++;
            } else {
                if (count > maxlen) {
                    maxlen =  count;
                }
                count = 0;
            }
        }
        maxlen = Math.max(maxlen, count);
        return maxlen;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,1,2};
        System.out.println(longestSubarray(arr));
    }
}
