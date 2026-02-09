public class partitionarray {
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        System.out.println(pivotArray(nums,10));
    }
    public static  int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num < pivot) {
                ans[index++] = num;
            }
        }
        for (int num : nums) {
            if (num == pivot) {
                ans[index++] = num;
            }
        }
        for (int num : nums) {
            if (num > pivot) {
                ans[index++] = num;
            }
        }

        return ans;
    }
   

}

