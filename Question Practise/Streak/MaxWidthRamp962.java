public class MaxWidthRamp962 {


//Approach-1 (Using brute force)
//T.C : O(n^2)
//S.C : O(1)

    public static int maxWidthRamp1(int[] nums) {
        int n = nums.length;
        int ramp = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] <= nums[j]) {
                    ramp = Math.max(ramp, j - i);
                }
            }
        }
        return ramp;
    }



//Approach-2 (early termination) - Passes 97/101 test cases
//T.C : O(n^2) in worst case
//S.C : O(1)

    public static int maxWidthRamp2(int[] nums) {
        int n = nums.length;
        int ramp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] <= nums[j]) {
                    ramp = Math.max(ramp, j - i);
                    break; // Exit inner loop early when a valid ramp is found
                }
            }
        }
        return ramp;
    }



//Approach-3 : Two Pointer (Making use of hint from Approach-2, storing max to the right) - ACCEPTED
//T.C : O(n)
//S.C : O(n)

    public static int maxWidthRamp(int[] nums) {
        int n = nums.length;

        // Create an array to store the maximum values from the right
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        
        // Fill the maxRight array
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        int ramp = 0;
        int i = 0;
        int j = 0;

        // Find the maximum width ramp
        while (j < n) {
            while (i < j && nums[i] > maxRight[j]) {
                i++;
            }
            ramp = Math.max(ramp, j - i);
            j++;
        }

        return ramp;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1};
        maxWidthRamp(nums);
    }
}