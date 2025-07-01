class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //base condition
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[] { grid[0][0], 0, 0 }); // index 0 -> time index 1 -> i, index 2 -> j
        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int time = curr[0];
            int i = curr[1];
            int j = curr[2];

            //reached destination
            if (i == m - 1 && j == n - 1) {
                return time;
            }

            if (visited[i][j]) {
                continue;
            }

            visited[i][j] = true;

            for (int[] dir : direction) {
                int newi = i + dir[0];
                int newj = j + dir[1];

                if (newi < 0 || newj < 0 || newi >= m || newj >= n || visited[newi][newj]) {
                    continue;
                }

                if (grid[newi][newj] <= time + 1) {
                    pq.add(new int[] { time + 1, newi, newj });
                } else if ((grid[newi][newj] - time) % 2 == 0) {
                    pq.add(new int[] { grid[newi][newj] + 1, newi, newj });
                } else {
                    pq.add(new int[] { grid[newi][newj], newi, newj });
                }
            }
        }

        return -1;
    }
}
