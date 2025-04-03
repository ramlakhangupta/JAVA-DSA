import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class DijkstraAlgoUsingset {

    static class iPair implements Comparable<iPair> {
        int first, second;
        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        // TreeSet ke liye comparison logic
        public int compareTo(iPair o) {
            if (this.first == o.first) return this.second - o.second;
            return this.first - o.first;
        }
    }

    ArrayList<Integer> dijkstra(int V, ArrayList<ArrayList<iPair>> adj, int source) {
        TreeSet<iPair> set = new TreeSet<>();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));

        result.set(source, 0);
        set.add(new iPair(0, source));

        while (!set.isEmpty()) {
            iPair it = set.pollFirst();
            int d = it.first;
            int node = it.second; 

            for(iPair neighbor : adj.get(node)) {
                int adjNode = neighbor.first;
                int wt = neighbor.second;

                if (d + wt < result.get(adjNode)) {
                    if (result.get(adjNode) != Integer.MAX_VALUE) {
                        set.remove(new iPair(result.get(adjNode), adjNode));
                    }

                    result.set(adjNode, d+wt);
                    set.add(new iPair(d+ wt, adjNode));
                }
            }
        }
        return result;
    }
}


