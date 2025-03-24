import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int u = 0; u<adj.size(); u++) {
            map.put(u, new ArrayList<>(adj.get(u)));
        }
        
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.fill(visited, false);
        
        BFS(map, 0, visited, result);
        return result;
    }
    
    public void BFS(Map<Integer, List<Integer>> map, int u, boolean[] visited, ArrayList<Integer> result ) {
        Queue<Integer> que = new LinkedList<>();
        que.add(u);
        visited[u] = true;
        result.add(u);
        
        while(!que.isEmpty()) {
             u = que.poll();
            for(int v : map.get(u)) {
                if(!visited[v]) {
                    que.add(v);
                    visited[v] = true;
                    result.add(v);
                }
            }
        }
    }
}
