import java.util.Arrays;

public class mostBeautifulItemForEachQuery2070 {
    

    //Brute Force Approach
    public int[] maximumBeauty1(int[][] items, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        // traverse
        for (int i = 0; i < queries.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < items.length; j++) {
                if (items[j][0] <= queries[i]) {
                    max = Math.max(max, items[j][1]);
                }
            }
            ans[i] = max == Integer.MIN_VALUE ? 0 : max;

        }
        return ans;
    }

    //Approach (simple binary search and preprocessing)
    //T.C : O(nlogn + n + mlogn)
    //S.C : O(1)
    private int customBinarySearch(int[][] items, int queryPrice) {
        int left = 0;
        int right = items.length - 1;
        int maxBeauty = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] > queryPrice) {
                right = mid - 1; // Move to the left side
            } else {
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                left = mid + 1;
            }
        }

        return maxBeauty;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int m = queries.length;
        int[] result = new int[m];

        // Step 1: Sort the items based on price in ascending order
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        // Update beauty values to make them non-decreasing
        int maxBeautySeen = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeautySeen = Math.max(maxBeautySeen, items[i][1]);
            items[i][1] = maxBeautySeen;
        }

        // Process each query using custom binary search
        for (int i = 0; i < m; i++) {
            int queryPrice = queries[i];
            result[i] = customBinarySearch(items, queryPrice);
        }

        return result;
    }
}
