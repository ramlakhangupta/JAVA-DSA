//TLE

class Solution {

    public boolean DFS(HashMap<Integer, List<int[]>> map, int u, boolean[] visited, int end, int target) {

        if (u == end) {
            return true;
        }
        visited[u] = true;

        for (int[] top : map.getOrDefault(u, new ArrayList<>())) {
            int v = top[0];
            int cost = top[1];
            if (!visited[v] && cost < target) {
                if (DFS(map, v, visited, end, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edgeList) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new int[] { edge[1], edge[2] });
            map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(new int[] { edge[0], edge[2] });
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int target = queries[i][2];
            boolean[] visited = new boolean[n];
            if (DFS(map, start, visited, end, target)) {
                ans[i] = true;
            } else {
                ans[i] = false;
            }
        }
        return ans;
    }
}
