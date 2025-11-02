class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int prevNo = Integer.MAX_VALUE;
        int[] ans = new int[2];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (prevNo == nums[i]) {
                ans[j] = nums[i];
                j++;
            } else {
                count = 1;
                prevNo = nums[i];
            }
        }
        return ans;
    }
}
