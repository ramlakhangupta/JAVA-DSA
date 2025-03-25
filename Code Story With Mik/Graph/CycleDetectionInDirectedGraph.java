import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CycleDetectionInDirectedGraph {

    public boolean checkCycleDFS(HashMap<Integer, ArrayList<Integer>> map, int i, boolean[] visited, boolean[] recursion) {
        visited[i] = true;
        recursion[i] = true;
        
        for(int v : map.get(i)) {
            if(visited[v] == false && checkCycleDFS(map, v, visited, recursion)) {
                return true;
            } else if(recursion[v] == true) {
                return true;
            }
            
        }
        recursion[i] = false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i< adj.size(); i++) {
            map.put(i, new ArrayList<>(adj.get(i)));
        }
        
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);
        
        for(int i = 0; i< adj.size(); i++) {
            if(visited[i]) {
                continue;
            }
            if(!visited[i] && checkCycleDFS(map, i, visited, new boolean[adj.size()])) {
                return true;
            }
        }
        return false;
    }
    
}