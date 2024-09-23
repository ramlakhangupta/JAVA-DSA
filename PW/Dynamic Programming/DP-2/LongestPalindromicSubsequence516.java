
public class LongestPalindromicSubsequence516 {

    //recursion + memoization
    public static int longestPalindromeSubseq1(String s) {
        StringBuilder str1 = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            str2.append(s.charAt(i));
        }
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(str1, str2, str1.length() - 1, str2.length() - 1, dp);
    }

    public static int helper(StringBuilder text1, StringBuilder text2, int t1end, int t2end, int[][] dp) {
        if (t1end < 0 || t2end < 0) {
            return 0;
        }

        if (dp[t1end][t2end] != -1)
            return dp[t1end][t2end];
        if (text1.charAt(t1end) == text2.charAt(t2end)) {
            return dp[t1end][t2end] = 1 + helper(text1, text2, t1end - 1, t2end - 1, dp);
        } else {
            return dp[t1end][t2end] = Math.max(helper(text1, text2, t1end - 1, t2end, dp),
                    helper(text1, text2, t1end, t2end - 1, dp));
        }

    }



    //tabulation
    public static int longestPalindromeSubseq(String a) {
        StringBuilder b = new StringBuilder(a);
        b.reverse();
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int p = (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0;
                int q = (i > 0) ? dp[i - 1][j] : 0;
                int r = (j > 0) ? dp[i][j - 1] : 0;
                dp[i][j] = (a.charAt(i) == b.charAt(j)) ? 1 + p : Math.max(q, r);
            }
        }
        return dp[m - 1][n - 1];

    }








    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}
