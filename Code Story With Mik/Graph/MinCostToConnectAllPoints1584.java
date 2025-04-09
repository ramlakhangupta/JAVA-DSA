class Solution {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            int xi = points[i][0];
            int yi = points[i][1];

            for (int j = i + 1; j < V; j++) {
                int xj = points[j][0];
                int yj = points[j][1];

                int wt = Math.abs(xi - xj) + Math.abs(yi - yj);

                edges.add(new int[] { i, j, wt });
            }
        }

        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        edges.sort(Comparator.comparingInt(a -> a[2]));

        int cost = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (find(u, parent) != find(v, parent)) {
                union(u, v, parent, rank);
                cost += wt;
            }
        }
        return cost;
    }

    public int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (x_parent == y_parent) {
            return;
        }

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[y_parent] > rank[x_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
}
