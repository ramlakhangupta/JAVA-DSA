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

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cost = edge[2];
            int parU = find(u, parent);
            int parV = find(v, parent);

            if (parU == parV) {
                int freq = map.getOrDefault(parU, cost);
                map.put(parU, freq & cost);
                continue;
            }

            union(u, v, parent, rank);
            int newPar = find(u, parent);

            int freq1 = map.getOrDefault(parU, cost);
            int freq2 = map.getOrDefault(parV, cost);
            map.put(newPar, freq1 & freq2 & cost);
        }

        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int u = query[i][0], v = query[i][1];
            int parU = find(u, parent);
            int parV = find(v, parent);

            if (parU == parV) {
                ans[i] = map.getOrDefault(parU, -1);
            } else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}
