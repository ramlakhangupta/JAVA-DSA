public static int trap(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int result = 0;

    while (left < right) {
        if (arr[left] < arr[right]) {
            if (arr[left] >= leftMax) {
                leftMax = arr[left];
            } else {
                result += leftMax - arr[left];
            }
            left++;
        } else {
            if (arr[right] >= rightMax) {
                rightMax = arr[right];
            } else {
                result += rightMax - arr[right];
            }
            right--;
        }
    }
    return result;
}
