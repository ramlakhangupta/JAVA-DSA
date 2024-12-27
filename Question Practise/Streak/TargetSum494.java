public class TargetSum494 {
    
    static int count;

    public static int findTargetSumWays(int[] nums, int target) {
        count = 0;
        return helper(nums, target, 0, 0);
    }

    public static int helper(int[] nums, int target, int index, int result) {

        if (index == nums.length) {
            return result == target ? 1 : 0;
        }

        int left = helper(nums, target, index + 1, result + nums[index]);
        int right = helper(nums, target, index + 1, result - nums[index]);

        return left + right;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(arr, target));
    }
}
