import java.util.*;
public class uniquePaths62 {
    // DP by recursion with memoization
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <  n; j++) {
                dp[i][j] = -1;
            }
        }

       return paths(0,0,m,n,dp);
    }

    private int paths(int row, int col, Integer m, Integer n, int[][] dp) {
        if (row>= m || col>= n) {
            return 0;
        }
        if (row== m-1 && col== n-1) {
            return 1;
        }
        if ( dp[row][col] != -1) {
            return dp[row][col];
        }
        int right = paths(row, col+1, m, n,dp);
        int down = paths(row+1, col, m, n,dp);
        return dp[row][col] = right + down;
    }

    // BY TABULATION
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j]+ dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
