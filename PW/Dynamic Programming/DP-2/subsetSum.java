
public class subsetSum {
    public static void main(String[] args) {
        int[] arr = {0,8,5,2,4};
        int target = 11;
        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(sub(arr,target,0,dp));
        System.out.println(sub1(arr,target,0,0));
    }

    private static boolean sub1(int[] arr, int target, int i,int sum ) {
        if (i == arr.length) {
            if (sum == target) {
                return true;
            } else {
                return false;
            }
        }
        boolean  skip =  sub1(arr,target,i+1, sum);
        if (sum+arr[i] > target) {  //only valid for positive numbers
            return skip;     
        }
        boolean  pick = sub1(arr, target, i+1, sum + arr[i]);
        
        return skip || pick;
    }

    private static boolean sub(int[] arr, int target, int i, int[][] dp ) {
        if (i == arr.length) {
            if (target == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (dp[i][target] != -1) {
            if (dp[i][target] == 1)  {
                return true;
            } else {
                return false;
            }
        }
        boolean ans = false;

        boolean  skip =  sub(arr,target,i+1,dp);
        if (target-arr[i] < 0) {  //only valid for positive numbers
              ans = skip;
        } else {
            boolean  pick = sub(arr, target-arr[i], i+1,dp);
            ans = skip || pick;
        }
        if (ans) {
            dp[i][target] = 1;
        } else {
            dp[i][target] = 0;
        }
        return ans;
    }
}
