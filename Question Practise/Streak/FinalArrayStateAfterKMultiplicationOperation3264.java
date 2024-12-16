import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperation3264 {
    

    //Approach-1 (Brute Force)
    //T.C : O(n * k)
    //S.C : O(1)
    public int[] getFinalState1(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for (int j = 0; j < k; j++) {
            int idx = 0;

            // Find the index of the smallest element
            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[idx]) {
                    idx = i;
                }
            }

            // Multiply the smallest element by the multiplier
            nums[idx] *= multiplier;
        }

        return nums;
    }



    //Approach-2 (Using vector as heap for O(n) heapify)
    //T.C : O(n + klogn)
    //S.C : O(n)
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Priority queue to store pairs of (value, index) with a custom comparator
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int valueComparison = Integer.compare(a[0], b[0]);
            if (valueComparison == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return valueComparison;
        });

        // Initialize the heap with values and their indices
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] { nums[i], i });
        }

        // Perform k iterations
        while (k-- > 0) {
            // Extract the smallest element
            int[] temp = heap.poll();
            int idx = temp[1];
            int number = temp[0];

            // Update the array and reinsert the updated value into the heap
            nums[idx] = number * multiplier;
            heap.offer(new int[] { nums[idx], idx });
        }

        return nums;
    }
}

