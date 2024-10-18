class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        int n = nums.length;
        
        // Step 1: Calculate the maximum possible OR value by ORing all elements.
        for (int num : nums) {
            maxOr |= num;
        }
        
        // Step 2: Count subsets with OR value equal to maxOr.
        return countSubsets(nums, n, maxOr);
    }
    
    private int countSubsets(int[] nums, int n, int maxOr) {
        int count = 0;
        
        // Iterate through all subsets.
        for (int subset = 1; subset < (1 << n); subset++) {
            int currentOr = 0;
            
            // Compute OR for the current subset.
            for (int i = 0; i < n; i++) {
                if ((subset & (1 << i)) != 0) {
                    currentOr |= nums[i];
                }
            }
            
            // If current subset's OR is equal to maxOr, increment the count.
            if (currentOr == maxOr) {
                count++;
            }
        }
        
        return count;
    }
}
