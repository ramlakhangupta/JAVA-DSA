public class FindIfArrayCanBeSorted3011 {
    public static boolean canSortArray(int[] nums) {
        
        for(int i=0; i<nums.length-1; i++){

            // check sorted or not 
            if(nums[i] < nums[i+1]){
                continue;
            } 

                while( nums[i] > nums[i+1]  ){
                //check nums[i] and nums[i+1] have adjacent set bits or not 
                if(isCheck(nums[i], nums[i+1])){
                    //swap
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                } else {
                    return false;
                }
            }

            while (i > 0 && nums[i-1] > nums[i]) {
                if(isCheck(nums[i-1], nums[i])){
                    //swap
                    int temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
                } else {
                    return false;
                }
                i--;
            }
        }
        return true;
    }

    private static boolean isCheck(int a , int b){
         int count1 = 0;

        while (a > 0) {
            // Check the least significant bit
            count1 += a & 1;

            // Right shift the number to check the next bit
            a >>= 1;
        }

         int count2 = 0;

        while (b > 0) {
            // Check the least significant bit
            count2 += b & 1;

            // Right shift the number to check the next bit
            b >>= 1;
        }
        if(count1 == count2){
            return true;
        }
        return false;

    }


    //Approach-1 (Using Bubble Sort)
//T.C : O(n^2)
//S.C : O(1)
    public boolean canSortArray2(int[] nums) {
        int n = nums.length;
        boolean swapped = true;

        for (int i = 0; i < n; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) { // in every pass, the max element bubbles up to the rightmost index
                if (nums[j] <= nums[j + 1]) {
                    // no swap required
                    continue;
                } else {
                    // swap is required
                    if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j + 1])) {
                        // swapping nums[j] and nums[j + 1]
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        swapped = true;
                    } else {
                        // not able to swap, hence can't sort it
                        return false;
                    }
                }
            }

            if (!swapped) { // no swapping was done in the pass, hence array was already sorted
                break; // no more passes are required
            }
        }

        return true;
    }



//Approach-2 (Using simple segment sorting check)
//T.C : O(n)
//S.C : O(1)
    public boolean canSortArray1(int[] nums) {
        // Current Segment
        int numOfSetBits = Integer.bitCount(nums[0]);
        int maxOfSegment = nums[0];
        int minOfSegment = nums[0];
        int maxOfPrevSegment = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (Integer.bitCount(nums[i]) == numOfSetBits) { // they belong to the same segment
                // Find max of current segment
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
                // Find min of current segment
                minOfSegment = Math.min(minOfSegment, nums[i]);
            } else { // Element belongs to a new segment

                if (minOfSegment < maxOfPrevSegment) { // condition to check proper segment arrangement
                    return false;
                }

                // Update the previous segment's max
                maxOfPrevSegment = maxOfSegment;

                // New segment starts now
                maxOfSegment = nums[i];
                minOfSegment = nums[i];
                numOfSetBits = Integer.bitCount(nums[i]);
            }
        }

        // Final check for proper segment arrangement
        if (minOfSegment < maxOfPrevSegment) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = {3,16,8,4,2};
        System.out.println(canSortArray(arr));
    }
}
