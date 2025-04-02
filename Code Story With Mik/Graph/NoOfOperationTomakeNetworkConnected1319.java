class Solution {

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
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length + 1 < n) {
            return -1;
        }
        int component = n;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < connections.length; i++) {
            int x = connections[i][0];
            int y = connections[i][1];

            int x_parent = find(connections[i][0], parent);
            int y_parent = find(connections[i][1], parent);

            if (x_parent == y_parent) {
                continue;
            }

            union(x, y, parent, rank);
            component--;
        }

        return component - 1;
    }
}
