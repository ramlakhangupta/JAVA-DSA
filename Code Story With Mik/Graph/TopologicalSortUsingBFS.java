import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i<adj.size(); i++) {
            map.put(i, new ArrayList<>(adj.get(i)));
        }
        
        // 1
        int[] indegree = new int[map.size()];
        Arrays.fill(indegree, 0);
        for(int i = 0; i<map.size(); i++) {
            for(int v : map.get(i)) {
                indegree[v]++;
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        //2. fill que, indegree with 0
        for(int i=0; i< map.size(); i++) {
            if(indegree[i] == 0) {
                que.add(i);
            }
        }
        
        // 3. simple BFS
        ArrayList<Integer> result = new ArrayList<>();
        while(!que.isEmpty()) {
            int u = que.poll();
            result.add(u);
            
            for(int v : map.get(u)) {
                indegree[v]--;
                
                if(indegree[v] == 0) {
                    que.add(v);
                }
            }
        }
        return result;
    }
    
}
