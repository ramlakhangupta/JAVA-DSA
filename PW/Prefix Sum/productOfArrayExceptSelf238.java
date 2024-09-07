public class productOfArrayExceptSelf238 {


    //In this Problem we cant use "/" so this code is not work
    // public static int[] productExceptSelf(int[] nums) {
    //     int mul = 1;
    //     for (int i = 0; i < nums.length; i++) {
    //         mul *= nums[i];
    //     }

    //     for (int i = 0; i < nums.length; i++) {
    //         nums[i] =(int)(mul/nums[i]);
    //     }
    //     return nums;
    // }

//Creating 3 new Array
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }
        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n-2; i >= 0; i--) {
            suf[i] = nums[i+1] * suf[i+1];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = pre[i] * suf[i];
        }
        return result;
    }

    //Creating 2 new Array
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }
        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n-2; i >= 0; i--) {
            suf[i] = nums[i+1] * suf[i+1];
        }
      
        for (int i = 0; i < n; i++) {
            nums[i] = pre[i] * suf[i];
        }
        return nums;
    }


    //Creating only 1 new array
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }
       int suff = 1;
        for (int i = n - 2; i >= 0; i--) {
            suff *= nums[i + 1];
            pre[i] *= suff;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        productExceptSelf2(arr);
    }
}
