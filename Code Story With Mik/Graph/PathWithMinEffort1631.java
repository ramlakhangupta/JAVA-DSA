class Solution {
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        result[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 }); // {x, y};

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[1];
            int y = top[2];

            int d = top[0];

            if (x == m - 1 && y == n - 1) {
                return result[x][y];
            }

            for (int[] dir : directions) {
                int i = dir[0] + x;
                int j = dir[1] + y;

                if (isSafe(i, j, m, n)) {
                    int minus = Math.abs(heights[x][y] - heights[i][j]);
                    if (minus < d) {
                        minus = d;
                    }
                    if (result[i][j] > minus) {
                        result[i][j] = minus;
                        pq.add(new int[] { minus, i, j });
                    }
                }

            }
        }
        return 0;
    }

    public boolean isSafe(int i, int j, int m, int n) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
            return true;
        }
        return false;
    }
} 
