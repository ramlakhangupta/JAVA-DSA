///////////////////////////////////////////////////////////////      BRUTE FORCE      ///////////////////////////////////////////////
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int val = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum >= target) {
                        if (diff > sum - target) {
                            diff = sum - target;
                            val = sum;
                        }
                    } else {
                        if (diff > target - sum) {
                            diff = target - sum;
                            val = sum;
                        }
                    }
                }
            }
        }
        return val;
    }
}

///////////////////////////////////////////////////////////      OPTIMIZED      ///////////////////////////////////////////////
