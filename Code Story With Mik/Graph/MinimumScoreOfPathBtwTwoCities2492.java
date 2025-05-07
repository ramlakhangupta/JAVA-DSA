class Solution {

    int ans = Integer.MAX_VALUE;

    public void DFS(HashMap<Integer, List<int[]>> map, int u, boolean[] visited, int n) {
        visited[u - 1] = true;

        for (int[] neighbor : map.getOrDefault(u, new ArrayList<>())) {
            ans = Math.min(ans, neighbor[1]);
            if (!visited[neighbor[0] - 1]) {
                DFS(map, neighbor[0], visited, n);
            }
        }
        return;
    }

    public int minScore(int n, int[][] roads) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], key -> new ArrayList<>()).add(new int[] { road[1], road[2] });
            map.computeIfAbsent(road[1], key -> new ArrayList<>()).add(new int[] { road[0], road[2] });
        }

        boolean[] visited = new boolean[n];

        DFS(map, 1, visited, n);
        return ans;
    }
}
