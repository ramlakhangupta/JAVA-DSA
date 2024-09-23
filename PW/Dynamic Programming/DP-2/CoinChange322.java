public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length ; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = (int)helper(0, coins, amount, dp);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
        
    }
    public long helper(int i, int[] coins, int amount, long[][] dp) {
        if (i == coins.length) {
            if (amount == 0) {
                return 0; //no more coins needed
            } else {
                return Integer.MAX_VALUE; // not a valid combination
            }
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        long skip = helper(i+1, coins, amount, dp);
        if (amount - coins[i] < 0) {
            return dp[i][amount] =  skip;
        }
        long take = 1 + helper(i, coins, amount-coins[i], dp);
        return dp[i][amount] = Math.min(skip,take);
    }
}
