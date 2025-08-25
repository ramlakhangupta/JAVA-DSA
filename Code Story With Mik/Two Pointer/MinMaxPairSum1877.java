class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int start = 0;
        int end = n - 1;

        int ans = Integer.MIN_VALUE;
        while (start < end) {
            ans = Math.max(ans, nums[start] + nums[end]);
            start++;
            end--;
        }

        return ans;
    }
}
