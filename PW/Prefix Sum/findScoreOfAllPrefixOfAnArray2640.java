public class findScoreOfAllPrefixOfAnArray2640 {
    public static long[] findPrefixScore(int[] nums) {
        long[] ans = new long[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ans.length; i++) {
            max = Math.max(max, nums[i]);
            ans[i] = nums[i] + max;
        }

        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i-1];
        }



    return ans;

    }

    public static void main(String[] args) {
        int[] arr = {2,3,7,5,10};
        findPrefixScore(arr);
    }
}
