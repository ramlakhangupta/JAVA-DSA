public class SpecialArrayii3152 {

    // TLE
    public boolean[] isArraySpecial1(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = true;
            while (start < end) {
                if ((nums[start + 1] % 2 != 0 && nums[start] % 2 == 0)
                        || (nums[start] % 2 != 0 && nums[start + 1] % 2 == 0)) {
                    start++;
                    continue;
                } else {
                    result[i] = false;
                    break;
                }

            }

        }
        return result;
    }


        // prefix sum concept
        public static boolean[] isArraySpecial2(int[] nums, int[][] queries) {
    
            boolean[] result = new boolean[queries.length];
            int n = nums.length;
            int[] prefixSum = new int[n];
    
            // prefix sum
            int count = 0;
            prefixSum[0] = 0;
            for (int i = 0; i < n - 1; i++) {
                if ((nums[i] % 2 == 0 && nums[i + 1] % 2 != 0) || (nums[i] % 2 != 0 && nums[i + 1] % 2 == 0)) {
                    prefixSum[i + 1] = count;
                } else {
                    count++;
                    prefixSum[i + 1] = count;
                }
            }
    
            int index = 0;
            for (int[] querie : queries) {
                int i = querie[0];
                int j = querie[1];
    
                if (prefixSum[i] - prefixSum[j] == 0) {
                    result[index] = true;
                }
                index++;
            }
            return result;
    
        }


    //Approach-2 (Using 2 pointers)
    //T.C : O(n + m)
    //S.C : O(n)
    public boolean[] isArraySpecial3(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] validRightMostIdx = new int[n];
        // validRightMostIdx[i] = j; the rightmost index starting from i which is a special subarray [i..j]

        int i = 0;
        int j = 0;

        while (i < n) {
            if (j < i) {
                j = i;
            }

            while (j + 1 < n && nums[j] % 2 != nums[j + 1] % 2) {
                j++;
            }

            validRightMostIdx[i] = j;
            i++;
        }

        boolean[] result = new boolean[m];

        for (int k = 0; k < m; k++) {
            int start = queries[k][0];
            int end = queries[k][1];

            if (end <= validRightMostIdx[start]) {
                result[k] = true;
            } else {
                result[k] = false;
            }
        }

        return result;
    }
    

    public static void main(String[] args) {
        int[] nums = {4,3,1,6};
        int[][] n = {{0,2}, {2,3}};
        System.out.println(isArraySpecial2(nums, n));
    }
}
