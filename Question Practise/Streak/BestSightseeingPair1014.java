public class BestSightseeingPair1014 {

    public int maxScoreSightseeingPair(int[] arr) {
        int maxScore = Integer.MIN_VALUE;
        int maxLeft = arr[0]; // Initial maxLeft as arr[0] + 0

        for (int j = 1; j < arr.length; j++) {
            // Calculate the score for the current pair (i, j)
            maxScore = Math.max(maxScore, maxLeft + arr[j] - j);

            // Update maxLeft for the next iteration
            maxLeft = Math.max(maxLeft, arr[j] + j);
        }

        return maxScore;
    }
}