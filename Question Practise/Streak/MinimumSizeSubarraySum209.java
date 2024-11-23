public class MinimumSizeSubarraySum209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int sum = 0;
        int minL = n + 1;

        while (j < n) {
            sum += nums[j];

            while (sum >= target) {
                minL = Math.min(minL, j - i + 1);
                sum -= nums[i];
                i++;
            }

            j++;
        }

        return minL == n + 1 ? 0 : minL;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int target = 4;
        System.out.println(minSubArrayLen(target, nums));
    }
}
