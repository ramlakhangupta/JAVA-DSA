

public class grumpyBookstoreOwner1052 {
    public int maxSatisfied(int[] arr, int[] grumpy, int k) {
        int n = arr.length, i = 0, j = k-1, unsatisfied = 0, a = i, b = j, maxunsatisfied = 0;
        for (int l = i; l <= j; l++) {
            if (grumpy[l] == 1) {
                unsatisfied += arr[l];
            }

        }
        while (j<n) {
            if (maxunsatisfied < unsatisfied) {
                maxunsatisfied = unsatisfied;
                a = i; b= j;
            }
            i++; j++;
            if (j < n && grumpy[j] == 1) {
                unsatisfied += arr[j];
            }
            if (grumpy[i-1] == 1) {
                unsatisfied -= arr[i-1];
            }
        }
        for (int l = a; l <= b; l++) {
            grumpy[l] = 0;
        }
        int satisfied = 0;
        for (int l = 0; l < n; l++) {
            if (grumpy[l] == 0 ) {
                satisfied += arr[l];
            }
        }
        return satisfied;
    }
}
