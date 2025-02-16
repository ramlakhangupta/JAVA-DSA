int m;
    int n;
    int result;
    int nonObstacles;

    public void find(int[][] grid, int count, int i, int j, int[][] dir) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1) {
            return;
        }

        if (grid[i][j] == 2) {
            if (count == nonObstacles) {
                result++;
            }
            return;
        }

        grid[i][j] = -1;

        // backtrack
        for (int[] arr : dir) {
            int newi = i + arr[0];
            int newj = j + arr[1];

            find(grid, count + 1, newi, newj, dir);
        }

        grid[i][j] = 0;

    }

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        result = 0;
        nonObstacles = 0;

        int start_x = 0;
        int start_y = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    nonObstacles++;
                }
                if (grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;

                }
            }
        }
        nonObstacles += 1;

        int count = 0;

        find(grid, count, start_x, start_y, dir);

        return result;

    }
