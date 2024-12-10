import java.util.Arrays;

public class MinimumNoDaysMakemBouquets1482 {
    public static int minDays(int[] bloomDay, int m, int k) {
        int start = 1;
        int end = Arrays.stream(bloomDay).max().getAsInt();
        int result = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result == 0 ? -1 : result;
    }

    public static boolean isPossible(int[] bloomDay, int m, int k, int mid) {
        int total = 0; // Count of bouquets formed
        int flowers = 0; // Consecutive flowers ready for one bouquet
    
        for (int day : bloomDay) {
            if (day <= mid) {
                flowers++;
                if (flowers == k) {
                    total++;
                    flowers = 0; // Reset for the next bouquet
                }
            } else {
                flowers = 0; // Reset if the sequence is broken
            }
    
            if (total >= m) {
                return true; // Found enough bouquets
            }
        }
    
        return false; // Not enough bouquets can be formed
    }
    

    public static void main(String[] args) {
        int[] arr = {1000000000,1000000000};
        int m = 1;
        int n = 1;
        System.out.println(minDays(arr, m, n));
    }
}
