import java.util.*;
public class houseRobber198 {

    public static int amount(int[] nums, int i, int[] dp) {
        if (i>= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + amount(nums, i+2, dp);
        int skip = amount(nums, i+1, dp);
        return dp[i] = Math.max(take, skip);
    }

    // BY MEMOIZATION 
    public static int rob1(int[] nums) {
        // 'i' varies from 0 to n-1
        // dp[i] will store the value of amount(i)
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return amount(nums, 0,dp);
    }

    

    //BY TABULATION
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return  dp[nums.length-1];

    }

}
