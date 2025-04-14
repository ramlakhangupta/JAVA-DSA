class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> que = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    que.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int minutes = 0;

        while (!que.isEmpty()) {
            int N = que.size();

            while (N > 0) {
                int[] curr = que.poll();
                int i = curr[0];
                int j = curr[1];

                for (int[] dir : directions) {
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1) {
                        grid[new_i][new_j] = 2;
                        freshCount--;
                        que.offer(new int[] { new_i, new_j });
                    }

                }
                N--;
            }
            minutes++;
        }

        return freshCount == 0 ? minutes - 1 : -1;

    }
}
