public class targetSum{
    static int count = 0;
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(findTargetSumWays(nums,1));
    }

    public static int findTargetSumWays(int[] nums, int target){
        solve(nums, 0, 0, target);
        return count;
    } 

    public static void solve(int[] nums, int i, int sum, int target){
        if(i == nums.length){
            if (sum == target) {
                count++;
            }
        } else {
            solve(nums, i+1, sum + nums[i], target);
            solve(nums, i+1, sum - nums[i], target);
        }
    }
    
}