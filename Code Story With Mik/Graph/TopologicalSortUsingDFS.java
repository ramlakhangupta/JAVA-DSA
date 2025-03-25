import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class TopologicalSortUsingDFS {
    

    public static void checkDFS(HashMap<Integer, ArrayList<Integer>> map, int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        
        for(int v : map.get(i)) {
            if(visited[v] == false) {
                checkDFS(map, v, visited, stack);
            }
            
        }
        
        stack.push(i);
        return ;
    }
    
    
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i<adj.size(); i++) {
            map.put(i, new ArrayList<>(adj.get(i)));
        }
        
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();
        for(int i= 0; i<map.size(); i++) {
            if(visited[i]) {
                continue;
            }
            checkDFS(map, i, visited, stack);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }

    
}
