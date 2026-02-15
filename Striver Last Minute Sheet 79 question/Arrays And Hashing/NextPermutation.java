class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int golaElement = Integer.MIN_VALUE;
        //find golaElement
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                golaElement = i - 1;
                break;
            }
        }

        if (golaElement != Integer.MIN_VALUE) {
            int swapElement = Integer.MIN_VALUE;
            for (int i = n - 1; i > golaElement; i--) {
                if (nums[golaElement] < nums[i]) {
                    swapElement = i;
                    break;
                }
            }

            swap(nums, golaElement, swapElement);

            reverse(nums, golaElement + 1);

        } else {
            reverse(nums, 0);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int i) {
        int n = nums.length - 1;
        while (n > i) {
            swap(nums, i, n);
            i++;
            n--;
        }
    }
}
