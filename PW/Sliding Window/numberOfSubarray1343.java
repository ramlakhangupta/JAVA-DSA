public class numberOfSubarray1343 {

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0, j = k-1, count = 0, sum = 0;
        for (int l = 0; l < k; l++) {
            sum += arr[l];
        }
        i++;
        j++;
        if (sum/k >= threshold) {
            count += 1;
        }
        while (j < arr.length) {
            sum = sum - arr[i-1] + arr[j];
           
            if (sum/k >= threshold)   {
                count += 1;
            }
            i++; j++;
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {11,13,17,23,29,31,7,5,2,3};
        int k = 3;
        int h = 5;
        System.out.println(numOfSubarrays(arr, k, h));
    }
}