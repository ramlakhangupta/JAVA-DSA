public class targetSum494 {

    //recursion
    public int findTargetSumWays1(int[] arr, int target) {
        return helper(arr, target, 0);
    }

    public int helper(int[] arr, int target, int i) {
        if(i == arr.length){
            if(target == 0) return 1;
            else return 0;
        }
        int add = helper(arr,target-arr[i], i+1);
        int sub = helper(arr,target+arr[i], i+1);
         
        return add+sub;
    }   


    //DP (Memoization)
    static int sum;
    public int findTargetSumWays(int[] arr, int target) {
        //i -> 0 to n-1 | res = -sum to sum 
        //dp[i][res+sum] -> ways(i,res)
        sum = 0;
        int n = arr.length;
        for(int ele : arr){
            sum += ele;
        }
        int[][] dp = new int[n][2*sum+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return ways(0, arr, 0, target, dp);
    }

    public int ways(int i, int[] arr, int res, int target, int[][] dp){
        if(i == arr.length){
            if(res == target) return 1;    // valid way
            else return 0;
        }
        if(dp[i][res+sum] != -1) return dp[i][res+sum];
        int add = ways(i+1,arr,res+arr[i], target,dp);
        int sub = ways(i+1,arr,res-arr[i], target,dp);
        return dp[i][res+sum] = add+sub;
    }
}
