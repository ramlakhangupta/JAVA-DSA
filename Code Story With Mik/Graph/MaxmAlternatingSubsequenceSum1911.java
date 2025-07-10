class Solution {
    Long[][] dp;

    public long solve(int i, int[] nums, boolean flag) {
        if (i >= nums.length) {
            return 0;
        }

        if(dp[i][flag ? 1 : 0] != null) {
            return dp[i][flag ? 1 : 0];
        }

        long skip = solve(i + 1, nums, flag);

        long val = nums[i];
        if(!flag) {
            val = -val;
        } 

        long take = solve(i+1, nums, !flag) + val;
        
        return dp[i][flag ? 1 : 0] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        dp = new Long[nums.length][2];
        return  solve(0, nums, true);
    }
}
