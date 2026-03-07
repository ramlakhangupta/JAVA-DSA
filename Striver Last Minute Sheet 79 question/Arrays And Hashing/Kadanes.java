//////////////////////////  BRUTE FORCE METHOD   ////////////////////////////////
 public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int sum = nums[i];
            for(int j = i+1; j < n; j++) {
                ans = Math.max(sum, ans);
                sum += nums[j];
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }

////////////////////////////    OPTIMIZED SOLUTION    //////////////////////////
public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            int val = nums[i];
            int temp_sum = val + sum;
            sum = Math.max(temp_sum, val);
            max = Math.max(sum, max);
        }
        return max;
    }
