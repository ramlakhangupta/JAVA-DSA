class Solution {

    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = colors.length();
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        int[][] t = new int[n][26];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                que.add(i);
                t[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int ans = 0;
        int countNode = 0;

        while (!que.isEmpty()) {
            int u = que.poll();
            countNode++;

            ans = Math.max(ans, t[u][colors.charAt(u) - 'a']);

            for (int v : map.getOrDefault(u, new ArrayList<>())) {
                for (int i = 0; i < 26; i++) {
                    int add = (colors.charAt(v) - 'a' == i) ? 1 : 0;
                    t[v][i] = Math.max(t[v][i], (t[u][i] + add));
                }

                indegree[v]--;
                if (indegree[v] == 0) {
                    que.add(v);
                }
            }

        }

        if (countNode < n) {
            return -1;
        }

        return ans;
    }
}
