class Solution {

    public int BFS(int[][] edges, int i, int k, HashMap<Integer, List<Integer>> map) {

        if (k < 0) {
            return 0;
        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[map.size()];
        que.add(i);
        visited[i] = true;

        int count = 0;
        while (!que.isEmpty() && k >= 0) {
            int n = que.size();

            while (n > 0) {
                int top = que.poll();
                count += 1;
                for (int v : map.getOrDefault(top, new ArrayList<>())) {
                    if (!visited[v]) {
                        que.add(v);
                        visited[v] = true;
                    }
                }
                n--;
            }
            k--;

        }
        return count;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        HashMap<Integer, List<Integer>> map1 = new HashMap<>();
        for (int[] edge : edges1) {
            map1.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            map1.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        int n = map1.size();

        HashMap<Integer, List<Integer>> map2 = new HashMap<>();
        for (int[] edge : edges2) {
            map2.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            map2.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        int m = map2.size();

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = BFS(edges1, i, k, map1);
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            maxValue = Math.max(maxValue, BFS(edges2, i, k - 1, map2));
        }

        for (int i = 0; i < n; i++) {
            result[i] += maxValue;
        }
        return result;
    }
}
