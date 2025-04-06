class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // {wt, reaching node}
        
        pq.offer(new int[] {0, 0});
        
        int sum = 0;
        
        boolean[] inMST = new boolean[V];
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int wt = top[0];
            int node = top[1];
            
            if(inMST[node]) continue;
            
            inMST[node] = true;
            
            sum += wt;
            
            for(int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int adjWt = neighbor[1];
                
                if(!inMST[adjNode]) {
                    pq.offer(new int[] {adjWt, adjNode});
                }
            }
        }
        return sum;
    }
