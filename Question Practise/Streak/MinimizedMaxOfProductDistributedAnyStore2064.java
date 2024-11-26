public class MinimizedMaxOfProductDistributedAnyStore2064 {
    public static int minimizedMaximum(int n, int[] quantities) {
        int max = Integer.MIN_VALUE;

        // max element
        for (int i = 0; i < quantities.length; i++) {
            max = Math.max(max, quantities[i]);
        }

        int[] arr = new int[max];
        for (int i = 1; i <= max; i++) {
            arr[i - 1] = i;
        }

        int start = 1;

        int end = max;
        int result = Integer.MAX_VALUE;
        // binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long var = 0;

            for (int i = 0; i < quantities.length; i++) {
                var += Math.ceil((double) quantities[i] / mid);

            }
            if (var <= n) {
                end = mid - 1;
                 result = Math.min(mid, result);
            } else {
                start = mid + 1;
            }
           

        }
        return result;

    }


    public static int minimizedMaximum1(int n, int[] quantities) {
        int max = 0;
    
        // Find the maximum element in quantities
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }
    
        int start = 1;
        int end = max;
        int result = max;
    
        // Binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long var = 0;
    
            // Calculate the number of groups needed for the current mid
            for (int quantity : quantities) {
                var += (quantity + mid - 1) / mid; // Optimized ceiling calculation
                if (var > n) break; // Early exit to reduce computations
            }
    
            // If the current distribution is possible
            if (var <= n) {
                result = mid;  // Update result to the smaller maximum
                end = mid - 1; // Try for a smaller maximum
            } else {
                start = mid + 1; // Increase the maximum to make distribution possible
            }
        }
    
        return result;
    }

        public static void main(String[] args) {
            int[] arr = {24,18,12,6,3,24,5,19,10,20,2,18,27,3,13,22,11,16,19,13};
            int n = 26;
            System.out.println(minimizedMaximum(n, arr));
        }
}
