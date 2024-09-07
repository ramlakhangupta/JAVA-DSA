public class runningSumOf1DArray {

    //In this extra space take
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            ans[i] = sum;
        }
        return ans;
    }


    //in this not extra space taken 
    public int[] runningSum1(int[] nums) {
       for (int i = 1; i < nums.length; i++) {
        nums[i] += nums[i-1];
       }
       return nums;
    }
}