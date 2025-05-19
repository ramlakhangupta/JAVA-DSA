class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] matrix = new int[n+1][n+1];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(matrix[i], 100000);
        }

        for(int i = 1; i < n; i++) {
            matrix[i][i+1] =  1;
            matrix[i+1][i] = 1;
        }

        matrix[x][y] = 1;
        matrix[y][x] = 1;

        for(int via = 1; via <= n; via++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1 ; j <= n ; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        int[] result = new int[n];
        for(int i = 1; i <= n; i++ ) {
            for(int j = 1; j <= n; j++) {
                if(i != j) {
                    int val = matrix[i][j];
                    result[val - 1]++;
                }
            }
        }
        return result;
    }
}
