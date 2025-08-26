class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int ans = 0;

        while (l < n) {
            if (r >= l && nums[l] + nums[r] <= target) {
                // ans = (int)(ans + Math.pow(2, r - l)) % 1000000007;
                int val = r-l;
                int temp = 1;
                while(val != 0) {
                    temp *= 2;
                    val--;
                }
                ans += temp;
                l++;
                r = n - 1;
            } else {
                if (r < l) {
                    l++;
                    r = n - 1;
                    continue;
                }
                r--;
            }

        }
        return ans;
    }
}  bhai 
