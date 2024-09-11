public class subArrayProductLessThanK713 {
    public static int numSubarrayProductLessThanK(int[] arr, int k) {
        int prod = 1,  count = 0, n = arr.length,  j=0;
        if (k <= 1) {
            return 0;
        }
        
        
        for(int i = 0; i < n; i++) {
            prod *= arr[i];
            while (prod >= k && j <= i) {
                prod /= arr[j];
                j++;
            }
            count += i - j + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;
        System.out.println(numSubarrayProductLessThanK(arr, k));
    }
}
