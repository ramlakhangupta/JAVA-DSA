class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int[] parent = new int[V];
        int[] rank = new int[V];
        
        for(int i=0; i< V; i++) {
            parent[i] = i;
            rank[i]=0;
        }
        
        //convert Adjacent list to edge list
        List<int[]> edges = new ArrayList<>();
        
        for(int u=0; u< V ; u++) {
            for(int[] pair : adj.get(u)) {
                int v = pair[0];
                int wt = pair[1];
                if(u < v) {
                    edges.add(new int[] { u, v, wt});
                }
            }
        }
        
        //step2 : sort all edges based on weight
        edges.sort(Comparator.comparingInt(a -> a[2]));
        
        //step 3 : apply kruskal algo
        int mstWeight = 0;
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if(find(u, parent) != find(v, parent)) {
                union(u, v, parent, rank);
                mstWeight += wt;
            }
        }
        
        return mstWeight;
    }
    
    public static int find(int x, int[] parent) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
    
    public static void union(int x, int y, int[] parent, int[] rank) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);
        
        if(x_parent == y_parent) {
            return ;
        }
        
        if(rank[x_parent] > rank[y_parent]) {
             parent[y_parent] = x_parent;
        } else if(rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
}
