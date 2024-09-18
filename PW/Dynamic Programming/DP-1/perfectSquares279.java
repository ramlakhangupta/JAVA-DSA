import java.util.Arrays;

public class perfectSquares279 {
    public static int minSquare(int n, int[] dp) {
        if (isperfect(n)) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <=n/2; i++) {
            int count = minSquare(i,dp) + minSquare(n-i,dp);
            min = Math.min(min, count);
        }
        return min;
    }

    private static boolean isperfect(int n) {
        int sqrt = (int)Math.sqrt(n);
        return (sqrt*sqrt == n);
    }

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return minSquare(n, dp);
    }
    public static void main(String[] args) {
        System.out.println(numSquares(4));
    }
}
