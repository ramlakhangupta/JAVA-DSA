import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlipColsForMaxmNoEqualRows1072 {
    //Approach-1 (Brute Force)
    //T.C : O(row^2 * col)
    //S.C : O(col)
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        int maxRows = 0;

        for (int[] currRow : matrix) {
            int[] inverted = new int[n];
            int count = 0;

            // Generate the inverted row
            for (int col = 0; col < n; col++) {
                inverted[col] = currRow[col] == 0 ? 1 : 0;
            }

            // Count matching rows (either equal to currRow or inverted)
            for (int[] row : matrix) {
                if (Arrays.equals(row, currRow) || Arrays.equals(row, inverted)) {
                    count++;
                }
            }

            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
    //Approach-2 (Using hashmap to store patterns)
    //T.C : O(row * col)
    //S.C : O(row*col)
    public int maxEqualRowsAfterFlips1(int[][] matrix) {
        
        int n = matrix[0].length;
        Map<String, Integer> rowPatterns = new HashMap<>(); // To store row patterns and their frequencies

        for (int[] row : matrix) { // Loop over each row
            StringBuilder rowPattern = new StringBuilder();
            int firstVal = row[0];

            // Generate the pattern for the current row
            for (int col = 0; col < n; col++) {
                rowPattern.append(row[col] == firstVal ? "S" : "B");
            }

            // Increment the frequency of the row pattern
            rowPatterns.put(rowPattern.toString(), rowPatterns.getOrDefault(rowPattern.toString(), 0) + 1);
        }

        int maxRows = 0;

        // Find the maximum frequency of any row pattern
        for (int count : rowPatterns.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,0,1},{1,1,0}};
        maxEqualRowsAfterFlips(matrix);
    }

}
