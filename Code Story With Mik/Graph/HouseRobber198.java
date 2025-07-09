class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;
        int[] t = new int[n+1];
        Arrays.fill(t, -1);
        t[0] = 0;
        t[1] = nums[0];

        for(int i = 2; i <= n; i++) {
            t[i] = Math.max((nums[i-1] + t[i-2]), t[i-1]);
        }
        return t[n];
    }
}
