import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DFS {
    public static void main(String[] args) {
    }

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int u=0; u<adj.size(); u++){
            map.put(u, new ArrayList<>(adj.get(u)));
        }

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);

        DFS(map, 0, visited, result );
        return result;
   }

   public void DFS(Map<Integer, ArrayList<Integer>> map, int u, boolean[] visited, ArrayList<Integer> result) {
        if(visited[u] == true){
            return;
        }

        visited[u] = true;
        result.add(u);
        for(int v : map.get(u)){
            if (!visited[v]) {
                DFS(map, v, visited, result);
            }
        }
   }
    
}


// steps to be followed : 

//     create a HashMap to store the graph;
//     create a boolean array to keep track of visited nodes;
//     create an ArrayList to store the result;
//     call the DFS function with the HashMap, the current node, the boolean array and the result ArrayList
//     inside the DFS function, mark the current node as visited and add it to the result ArrayList
//     iterate over the neighbors of the current node and call the DFS function with the HashMap, the neighbor
//     and the boolean array and the result ArrayList
//     at the end of the DFS function, return the result ArrayList;



//     thats all


// -------------------------

// Summary of whole thing 
//     a. map use ata h graph create karne ke liye (mtlb ye ek tarika h graph representation ka)
//     b. phir kya karte h apna technique apply karte h ki apan ko kya karna h like DFS, BFS
//     c. yadi DFS ue kar rhe h to uska logic likh lo , vice versa