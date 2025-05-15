class Solution {
    int N;

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

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
    }

    public int kruskal(int[][] edges, int skip, int add) {
        int sum = 0;

        UnionFind uf = new UnionFind(N);

        int edgeConnected = 0;

        if (add != -1) {
            uf.union(edges[add][0], edges[add][1]);
            sum += edges[add][2];
            edgeConnected++;
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skip) {
                continue;
            }

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            int parent_u = uf.find(u);
            int parent_v = uf.find(v);

            if (parent_u != parent_v) {
                uf.union(u, v);
                edgeConnected++;
                sum += wt;
            }
        }

        if (edgeConnected != N - 1) {
            return Integer.MAX_VALUE;
        }
        return sum;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        //step 1 
        // index add karo edges me 
        N = n;
        int[][] newedges = new int[edges.length][4];
        N = n;

        for (int i = 0; i < edges.length; i++) {
            newedges[i][0] = edges[i][0];
            newedges[i][1] = edges[i][1];
            newedges[i][2] = edges[i][2];
            newedges[i][3] = i; // edge index
        }

        Arrays.sort(newedges, Comparator.comparingInt(a -> a[2]));

        int MST_WEIGHT = kruskal(newedges, -1, -1);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            result.add(new ArrayList<>());
        }

        //check each edge from critical and pseudo critical
        for (int i = 0; i < newedges.length; i++) {
            if (kruskal(newedges, i, -1) > MST_WEIGHT) {
                result.get(0).add(newedges[i][3]);
            } else if (kruskal(newedges, -1, i) == MST_WEIGHT) {
                result.get(1).add(newedges[i][3]);
            }
        }
        return result;
    }
}
