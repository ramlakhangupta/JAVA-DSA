import java.util.Arrays;

public class CountTheNoFairPair2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        long count = 0;
        Arrays.sort(nums);
        int n = nums.length;


        for(int i=0; i<n;i++){
          int leftidx = lowerBound(nums,i+1,n,lower-nums[i]);
          int righttidx = upperBound(nums,i+1,n,upper-nums[i]);

          int x = leftidx - 1 - i;
          int y = righttidx - 1 - i;
        
          count += (y-x);
        }
        return count;
    }

    private int lowerBound(int[] nums , int start, int end, int target){
        while(start < end){
            int mid = start +(end-start)/2;
            if(nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    private int upperBound(int[] nums , int start, int end, int target){
        while(start < end){
            int mid = start +(end-start)/2;
            if(nums[mid] <= target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
