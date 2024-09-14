import java.util.*;

//BY MEMOIZATION
public class friendPairingProblem {
    
    public long countFriendsPairings1(int n) 
    { 
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return help(n,dp);
    }

    public long help(int n, long[] dp ) {
        if (n<=2) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
       return dp[n] =  help(n-1, dp) + (n-1)* help(n-2, dp);
    }



    //BY TABULATION
    public long countFriendsPairings(int n) { 
      double[] dp = new double[n+1];
      dp[1] = 1;
      if(n>1) dp[2] = 2;
      for(int i=3; i<=n; i++) {
          dp[i] =  dp[i-1] + (i-1)*dp[i-2];
      }
      
      return (long)dp[n];
    } 

    
}
