public class minimumSizeSubArraySum {
    public static int minSubArrayLen(int target, int[] arr) {
        int n = arr.length,  minlen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0, j = i;
            while (j < n  &&  sum < target) {
                sum += arr[j++];
            }
            j--;
            int len = j-i+1;
            if(sum >= target) minlen = Math.min(minlen, len);
        }
        if (minlen == Integer.MAX_VALUE) {
            return 0;
        }
        return minlen;
    }


    public static int minSubArrayLen1(int target, int[] arr) {
        int n = arr.length,  minlen = Integer.MAX_VALUE;
        int i=0, j=0, sum = 0;
        while (j<n && sum < target) {
            sum += arr[j++];
        }

        j--;
        //sliding window
        while (i<n && j<n) {
            int len = j-i+1;
            if (sum >= target)  minlen = Math.min(minlen, len);
            sum -= arr[i];
            i++; j++;
            while (j < n && sum < target) {
                sum += arr[j++];
            }
            j--;
        }
        if (minlen == Integer.MAX_VALUE) {
          return 0;
        }
        return minlen;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int k = 7;
        System.out.println(minSubArrayLen(k, arr));
    }
}
