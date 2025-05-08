//TLE

class Solution {
    int ans = -1;
    int level = 1;

    public void DFS(int[] edges, int u, boolean[] visited, int[] count, boolean[] inrecursion) {
        visited[u] = true;
        inrecursion[u] = true;
        count[u] = level;
        level++;

        int v = edges[u];

        if (v != -1) {
            if (!inrecursion[v]) {
                DFS(edges, v, visited, count, inrecursion);
            } else if (inrecursion[v]) {
                ans = Math.max(level - count[v], ans);
            }
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;

        boolean[] visited = new boolean[n];
        int[] count = new int[n];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(edges, i, visited, count, new boolean[n]);
            }
        }
        return ans;
    }
}

class Solution {
    int ans = -1;

    public void DFS(int[] edges, int u, boolean[] visited, int[] count, boolean[] inrecursion) {

        if (u != -1) {
            visited[u] = true;
            inrecursion[u] = true;

            int v = edges[u];

            if (v != -1 && !visited[v]) {
                count[v] = count[u] + 1;
                DFS(edges, v, visited, count, inrecursion);
            } else if (v != -1 && inrecursion[v]) {
                ans = Math.max(count[u] - count[v] + 1, ans);
            }

            inrecursion[u] = false;

        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;

        boolean[] visited = new boolean[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(edges, i, visited, count, new boolean[n]);
            }
        }
        return ans;
    }
}
