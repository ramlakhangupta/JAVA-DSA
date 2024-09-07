



public class rangeSumQuery_immutable303 {
    int[] arr;
    public void NumArray(int[] nums) { // constructor
        arr = nums; // shallow copy
        // arr = Arrays.copyOf(nums,nums.length);
        for (int i = 1; i < nums.length; i++) {
            arr[i] += arr[i-1];
        }

    }

    
    public int sumRange(int left, int right) {
       if (left == 0) {
        return arr[right];
       }

       return arr[right] - arr[left-1];
    }
}
