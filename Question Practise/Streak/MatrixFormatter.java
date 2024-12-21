import java.io.*;
import java.util.*;

public class MatrixFormatter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of matrices
        int N = Integer.parseInt(br.readLine().trim());

        // Read dimensions of each matrix
        String[] dims = br.readLine().trim().split(" ");
        int r = Integer.parseInt(dims[0]);
        int c = Integer.parseInt(dims[1]);

        // Read matrices
        int[][][] matrices = new int[N][r][c];
        for (int i = 0; i < r; i++) {
            String[] row = br.readLine().trim().split(" ");
            for (int j = 0; j < row.length; j++) {
                int matrixIndex = j / c;
                int colIndex = j % c;
                matrices[matrixIndex][i][colIndex] = Integer.parseInt(row[j]);
            }
        }

        // Read and process instructions
        String line;
        List<int[]> instructions = new ArrayList<>();
        while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
            String[] instruction = line.trim().split(" ");
            int[] matrixOrder = Arrays.stream(instruction).mapToInt(Integer::parseInt).toArray();
            instructions.add(matrixOrder);
        }

        // Print matrices as per instructions
        for (int[] instruction : instructions) {
            for (int matrixNum : instruction) {
                int[][] matrix = matrices[matrixNum - 1];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        System.out.print(matrix[i][j]);
                        if (j < c - 1) System.out.print(" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
