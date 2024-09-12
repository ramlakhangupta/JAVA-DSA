import java.util.Arrays;

public class nthTribonacciNo1137 {


    //DP BY MEMOIZATION
    public int tribonacci1(int n) {  
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return trio(n,dp);
    }

    private int trio(int n, int[] dp) {
        if(n == 0){
            return 0;
        }
        if ( n == 1 || n == 2) {
            return 1;
        }
        if (dp[n] != -1) {
            return  dp[n];
        }

        return dp[n] = trio(n-3, dp)+trio(n-2, dp)+trio(n-1, dp);

    }



    //DP BY TABHULATION
    public static int tribonacci(int n) {  
        if (n<=1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        tribonacci(4);
    }

}
