class Solution {
    int m;
    int n;
    int[][] dp;

    public int solve(String word1, String word2, int m, int n) {

        if (n == 0) {
            return m;
        }

        if (m == 0) {
            return n;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return dp[m][n] = solve(word1, word2, m - 1, n - 1);
        } else {
            return dp[m][n] = 1 + Math.min(solve(word1, word2, m - 1, n),
                    Math.min(solve(word1, word2, m, n - 1), solve(word1, word2, m - 1, n - 1)));
        }

    }

    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        dp = new int[501][501];
        for (int i = 0; i <= 500; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(word1, word2, m, n);
    }
}
