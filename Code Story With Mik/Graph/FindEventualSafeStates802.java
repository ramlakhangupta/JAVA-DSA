class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                map.computeIfAbsent(i, key -> new ArrayList<>()).add(graph[i][j]);
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean[] inrecursion = new boolean[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(map, i, visited, inrecursion);
            }
        }

        for (int i = 0; i < n; i++) {
            if (inrecursion[i] == false) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean DFS(HashMap<Integer, List<Integer>> map, int i, boolean[] visited, boolean[] inrecursion) {
        visited[i] = true;
        inrecursion[i] = true;

        for (int v : map.getOrDefault(i, new ArrayList<>())) {

            if (!visited[v] && DFS(map, v, visited, inrecursion)) {
                return true;
            } else if (inrecursion[v] == true) {
                return true;
            }
        }

        inrecursion[i] = false;
        return false;
    }
}
