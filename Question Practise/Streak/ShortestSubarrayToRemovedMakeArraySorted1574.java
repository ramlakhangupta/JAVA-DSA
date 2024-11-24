import java.util.Arrays;

public class ShortestSubarrayToRemovedMakeArraySorted1574 {
     public int findLengthOfShortestSubarray(int[] arr) {
        // binary search
        int n = arr.length;
        int count = 0;
        int[] copyArr = new int[n];

        // copies the value
        for(int i=0; i< n ; i++){
            copyArr[i] = arr[i];
        }
        

        Arrays.sort(copyArr);

        int j = 0;
        for(int i=0; i< n; i++){
            if (arr[i] == copyArr[j]) {
                count++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return n-count;
    }
}
