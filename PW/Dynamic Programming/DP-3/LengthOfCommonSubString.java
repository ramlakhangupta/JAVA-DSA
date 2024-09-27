public class LengthOfCommonSubString {
    public static int longestCommonSubstring(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else 
                    //dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
                
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        System.out.print(longestCommonSubstring("abcde", "fabggk"));
    }
}
