import java.util.Map;
import java.util.HashMap;
import java.util.List; 
public class GraphRepresentation {

    public static void main(String[] args) {
        int[][] arr = {{1,0},{2,0},{2,1},{3,1}};
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] ele : arr) {
            int v = ele[1];
            int u = ele[0];

            graph.put(u, v);
        }
        return solve(graph);
    }

    
}