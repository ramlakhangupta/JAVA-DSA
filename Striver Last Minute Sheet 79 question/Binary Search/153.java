/////////////////////////////////        BRUTE FORCE       ///////////////////////////////////////////////////
class Solution {
    public int findMin(int[] nums) {
        int ans = Arrays.stream(nums).min().getAsInt();
        return ans;
    }
}

////////////////////////////////         OPTIMIZED      //////////////////////////////////////////////////
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while(i <= j) {
            max = Math.max(max, Math.max(nums[j], nums[i]));
            min = Math.min(min, Math.min(nums[j], nums[i]));
            i++;
            j--;
        }

        return min;
    }
}
