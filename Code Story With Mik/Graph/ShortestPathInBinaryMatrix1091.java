class Solution {
    public int shortestPathBinaryMatrix(int[][] grids) {
        if (grids[0][0] != 0) {
            return -1;
        }
        int m = grids.length;

        int[][] direction = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { 0, 0 });
        int level = 1;
        while (!que.isEmpty()) {
            int n = que.size();

            while (n > 0) {
                int[] top = que.poll();
                int i = top[0];
                int j = top[1];
                if (i == m - 1 && j == m - 1) {
                    return level;
                }
                for (int[] dir : direction) {
                    int new_i = dir[0] + i;
                    int new_j = dir[1] + j;

                    if (isSafe(grids, new_i, new_j, m)) {
                        que.add(new int[] { new_i, new_j });
                        grids[new_i][new_j] = 1;
                    }
                }
                n--;
            }
            level++;
        }
        return -1;
    }

    public boolean isSafe(int[][] grid, int i, int j, int n) {
        if (i < n && j < n && i >= 0 && j >= 0 && grid[i][j] == 0) {
            return true;
        }
        return false;
    }
}
