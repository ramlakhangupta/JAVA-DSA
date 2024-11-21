public class TakeKEachCharacterFrormLeftRight2516 {


    //Approach-1 (Brute Force - Recursion)
    //T.C : O(2^n)
    //S.C : O(1) (But recursion stack space we are taking = O(n) in worst case i.e. depth of recursion will be equal to length of string)
    private int result = Integer.MAX_VALUE;

    public int takeCharacters(String s, int k) {
        int[] arr = new int[3];
        int i = 0;
        int j = s.length() - 1;
        solver(s, k, 0, i, j, arr);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public void solver(String s, int k, int minutes, int i, int j, int[] arr) {
        if (arr[0] >= k && arr[1] >= k && arr[2] >= k) {
            result = Math.min(result, minutes);
            return;
        }

        if (i > j) {
            return;
        }

        int[] left = arr.clone();
        left[s.charAt(i) - 'a']++;
        solver(s, k, minutes + 1, i + 1, j, left);

        int[] right = arr.clone();
        right[s.charAt(j) - 'a']++;
        solver(s, k, minutes + 1, i, j - 1, right);

    }



    //Approach-2 (Sliding Window)
    //T.C : O(n)
    //S.C : O(1)

    public int takeCharacters1(String s, int k) {
        int n = s.length();

        // Count total occurrences of 'a', 'b', and 'c'
        int countA = 0, countB = 0, countC = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') countA++;
            else if (ch == 'b') countB++;
            else if (ch == 'c') countC++;
        }

        // If any character occurs less than `k`, it's impossible to remove `k` instances
        if (countA < k || countB < k || countC < k) {
            return -1;
        }

        // Sliding window variables
        int i = 0, j = 0;
        int notDeletedWindowSize = 0;

        while (j < n) {
            // Reduce count for the character at index `j`
            if (s.charAt(j) == 'a') {
                countA--;
            } else if (s.charAt(j) == 'b') {
                countB--;
            } else if (s.charAt(j) == 'c') {
                countC--;
            }

            // If any count falls below `k`, shrink the window from the left
            while (i <= j && (countA < k || countB < k || countC < k)) {
                if (s.charAt(i) == 'a') {
                    countA++;
                } else if (s.charAt(i) == 'b') {
                    countB++;
                } else if (s.charAt(i) == 'c') {
                    countC++;
                }
                i++;
            }

            // Update the maximum size of the window
            notDeletedWindowSize = Math.max(notDeletedWindowSize, j - i + 1);
            j++;
        }

        // Calculate the minimum minutes required (total length - max window size)
        return n - notDeletedWindowSize;
    }
}

