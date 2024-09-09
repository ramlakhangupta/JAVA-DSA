public class maxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {10,20,1,3,-40,80,10};
        int k = 2;
        int  n  = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n-k+1; i++) {
            int sum = 0;
            for (int j = i; j < i+k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum(arr,k));
        System.out.println(maxSum);
    }


    //sliding window concept
    public static int maxSum(int[] arr, int k){
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        int j = k-1;
        int sum = 0;
        for (int l = 0; l < k; l++) {
            sum += arr[l];
        }

        i++;
        j++;

        while(j < arr.length){
            
            sum = sum - arr[i-1] + arr[j];
            maxSum = Math.max(maxSum, sum);
            i++; j++;
        }
        return maxSum;
    }
}