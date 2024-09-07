public class findPivotIndex724 {

    //Brute Force 
    public static int pivotIndex1(int[] nums) {
       
        // Calculate the sum of the entire array
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0, rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = i+1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum) {
                return i;
            }
            
        }
        return -1;
    }



    //good but it have high line of code
    public static int pivotIndex(int[] nums) {
        int[] arr = nums;
        
        for(int i=1; i<arr.length; i++) {
            arr[i] += arr[i-1];
        }


        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            if (i == 0) {
                leftSum = 0;
            }
            if (i > 0) {
                leftSum = arr[i-1];
            }
            if (i == arr.length-1) {
                rightSum = 0;
            }
            if (i < arr.length - 1) {
                rightSum =  arr[arr.length-1] - arr[i] ;
            }
            if (leftSum == rightSum) {
                return i;
            }
            
        }
        return -1;
    }


    //better approach with less line of code
    public static int pivotIndex2(int[] nums) {
        
        
        for(int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }


        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
           
            if (i > 0) {
                leftSum = nums[i-1];
            }
            int rightSum = nums[nums.length - 1] - nums[i];
            
            if (leftSum == rightSum) {
                return i;
            }
            
        }
        return -1;
    }


    
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        pivotIndex(arr);
    }
}
