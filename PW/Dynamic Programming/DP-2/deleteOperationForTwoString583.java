public class deleteOperationForTwoString583 {
    public int longestCommonSubsequence1(String text1, String text2) {
        StringBuilder str1 = new StringBuilder(text1);
        StringBuilder str2 = new StringBuilder(text2);
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(str1, str2, str1.length() - 1, str2.length() - 1, dp);
    }

    public int helper(StringBuilder text1, StringBuilder text2, int t1end, int t2end, int[][] dp) {
        if (t1end < 0 || t2end < 0) {
            return 0;
        }

        if (dp[t1end][t2end] != -1) {
            return dp[t1end][t2end];
        }

        if (text1.charAt(t1end) == text2.charAt(t2end)) {
            return dp[t1end][t2end] = 1 + helper(text1, text2, t1end - 1, t2end - 1, dp);
        } else {
            return dp[t1end][t2end] = Math.max(helper(text1, text2, t1end - 1, t2end, dp),
                    helper(text1, text2, t1end, t2end - 1, dp));
        }

    }

    public int minDistance(String word1, String word2) {
        return (word1.length() + word2.length()) - 2 * longestCommonSubsequence1(word1, word2);
    }
}
