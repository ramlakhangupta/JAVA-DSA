public class BinarySearch {
    public static void main(String[] args) {
        int nums[] = {-1,0,3,5,9,12};
        System.out.println(search(nums,13));

    }

    public static int search(int[] nums, int target) {
        
        return helper(nums,target,0,nums.length-1);
    }

    private static int helper(int[] nums, int target, int s, int e) {
        if(s>e){
            return -1;
        }
        int mid = s+(e-s)/2;
        if(nums[mid] == target){
            return mid;
        } 

        if(nums[mid] > target){
            return helper(nums, target, s, mid-1);

        } else{
            return helper(nums, target, mid+1, e);
        }

    }
}
