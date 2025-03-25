public class CycleDetectionInUndirectedGraph {
    
    //Using DFS
    public boolean isCycleDFS(Map<Integer, List<Integer>> map, int u, boolean[] visited, int parent) {
        visited[u] = true;
        
        for(int v : map.get(u)) {
            if(v == parent) continue;
            if(visited[v] == true) return true;
            if(isCycleDFS(map, v, visited, u)) return true;
        }
        return false;
    }
    
   
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int u = 0; u < adj.size(); u++) {
            map.put(u, new ArrayList<>(adj.get(u)));
        }
        
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);
        
        for(int u = 0; u< adj.size(); u++) {
            if(!visited[u] && isCycleDFS(map, u, visited, -1)){
                return true;
            }
        }
        return false;
    }

    //USING DFS
    
}
