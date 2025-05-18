class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;

        //trying all possible subsets
        for (int set = 0; set < (1 << n); set++) { // 1 << n  -> it represent same as it is to Math.pow(2, n);

            //set = 0 -> (000)
            int[][] grid = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    grid[j][k] = 1_000_000_000;
                }
            }

            //update the graph based on the selected nodes in the susbet
            for (int[] it : roads) {
                int u = it[0];
                int v = it[1];
                int wt = it[2];

                if ((set >> u & 1) == 1 && (set >> v & 1) == 1) {
                    grid[u][v] = Math.min(grid[u][v], wt);
                    grid[v][u] = Math.min(grid[v][u], wt);
                }
            }

            for (int i = 0; i < n; i++) {
                grid[i][i] = 0;
            }

            //floyd warshall to find shortest distance from any node to any other node 
            for (int via = 0; via < n; via++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][via] + grid[via][j]);
                    }
                }
            }

            //check if all shortest paths <= maxDistance
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }

                    if ((set >> i & 1) == 1 && (set >> j & 1) == 1) {
                        if (grid[i][j] > maxDistance) {
                            ok = false;
                            break;
                        }
                    }
                }
            }
            ans += ok ? 1 : 0;
        }
        return ans;
    }
}
