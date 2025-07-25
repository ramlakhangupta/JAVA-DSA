class Solution {
    int[][] dp;
    int m;
    int n;
    public int solve(int i, int j, String s1, String s2) {
        if (j == s2.length()) {
            return s1.length() - i;
        }

        if (i == s1.length()) {
            return s2.length() - j;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, s1, s2);
        } else {
            return dp[i][j] = 1 + Math.min(solve(i + 1, j, s1, s2),
                    Math.min(solve(i, j + 1, s1, s2), solve(i + 1, j + 1, s1, s2)));
        }

    }

    public int minDistance(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, s1, s2);
    }
}
