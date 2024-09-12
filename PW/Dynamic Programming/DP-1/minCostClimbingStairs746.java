
import java.util.*;

public class minCostClimbingStairs746 {

    //DP BY MEMOIZATION
    public int minCostClimbingStairs(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(minCost(arr,n-1, dp), minCost(arr, n-2, dp));
    }
    private int minCost(int[] arr, int i, int[] dp) {
        if (i == 0 || i == 1) {
            return arr[i];
        }
        if (dp[i] != -1) {
            return dp[i];
        }


        return dp[i] = arr[i] + Math.min(minCost(arr, i-1, dp), minCost(arr, i-2, dp));
    }

    //DP BY TABULATION
    public int minCostClimbingStairs1(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for (int i = 2 ; i < n ; i++) {
            dp[i] = arr[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }



}
