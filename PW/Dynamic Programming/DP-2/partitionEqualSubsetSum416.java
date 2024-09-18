public class partitionEqualSubsetSum416 {

    //recursion (TLE)
    public static boolean canPartition(int[] arr) {
        return helper(arr,0,0,0);
    }

    private static boolean helper(int[] arr, int i, int sumleft, int sumright) {
        if (i == arr.length) {
            if (sumleft == sumright) {
                return true;
            } else {
                return false;
            }
        }

        boolean left = helper(arr, i+1, sumleft+arr[i], sumright);
        
        boolean right = helper(arr, i+1, sumleft, sumright+arr[i]);

        return left || right;
    }

    //BY DP Memoization PW
    public static boolean canPartition1(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        if (sum%2 != 0) return false;
        int target = sum/2;
        int[][] dp = new int[arr.length][target+1];
        for (int i = 0; i < dp.length; i++) for (int j = 0; j < dp[0].length; j++)  dp[i][j] = -1;
        return helper(arr,0,target,dp);
    }

    private static boolean helper(int[] arr, int i, int target, int[][] dp) {
        if (i == arr.length) if (target == 0) return true; else return false;

        if (dp[i][target] != -1) return dp[i][target] == 1;
        boolean ans = false;
        boolean skip = helper(arr, i+1, target, dp);
        if (target - arr[i] < 0) ans = skip;
        else {
            boolean pick = helper(arr, i+1, target - arr[i], dp);
            ans = pick || skip;
        }

        if (ans) dp[i][target] = 1; else dp[i][target] = 0;

        return ans;
    }


    
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        System.out.println(canPartition(arr));
    }
}
