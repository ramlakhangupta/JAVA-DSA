import java.util.*;
public class countDearrangementGFG {
    public static long disarrange(int n){
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return count(n,dp);
    }

    public  static long count(int n ,long[] dp){
        if (n <=1) {
            return dp[n] = 0 ;
        }
        if (n == 2) {
            dp[2] = 1; 
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] =  ((((n-1)% 1000000007)* ( (disarrange(n-1)% 1000000007) + (disarrange(n-2)% 1000000007)))% 1000000007);
    
    }
}
