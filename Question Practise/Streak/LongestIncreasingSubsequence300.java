public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
