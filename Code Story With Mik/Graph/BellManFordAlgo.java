import java.util.Arrays;

public class BellManFord {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] result = new int[V];
        Arrays.fill(result, (int)1e8);
        result[src] = 0;
        
        //relax all edge v-1 times
        for(int count = 1; count <= V-1; count++) {
            for(int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(result[u] != (int)1e8 && result[u]+w < result[v] ) {
                    result[v] = result[u] + w;
                }
            }
        }
        
        //check for negative - weighted cycles
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(result[u] != (int)1e8 && result[u] +w < result[v]) {
                return new int[] {-1};
            }
        }
        return result;
    }
}
