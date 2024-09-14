import java.util.*;
public class climbStairs70 {

    //by memoization
    public static int climbStairs1(int n) {
        int[] dp = new int[n+1]; Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private static int helper(int n, int[] dp) {
        if(n<=2) return n;
        if (dp[n] != -1)  return dp[n];
        dp[n] = helper(n-1, dp) + helper(n-2, dp);
        return dp[n];
    }

    //by tabulation
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];  
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
