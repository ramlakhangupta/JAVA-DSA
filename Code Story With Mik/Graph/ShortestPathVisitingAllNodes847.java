class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1 || n == 0) {
            return 0;
        }
        int allVisitedState = (1 << n) - 1;

        Queue<int[]> que = new LinkedList<>();
        int[][] visited = new int[n][allVisitedState + 1];

        for (int i = 0; i < n; i++) {
            int maskValue = (1 << i);
            que.add(new int[] { i, maskValue });
            visited[i][maskValue] = 1;
        }

        int ans = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] top = que.poll();
                int currNode = top[0];
                int currMask = top[1];

                for (int adj : graph[currNode]) {
                    int nextMask = currMask | (1 << adj);
                    if (nextMask == allVisitedState) {
                        return ans;
                    }
                    if (visited[adj][nextMask] != 1) {
                        que.add(new int[] { adj, nextMask });
                        visited[adj][nextMask] = 1;
                    }
                }
            }
        }
        return -1;
    }

    class Pair {
        int val;
        int bitVal;

        Pair(int val, int bitVal) {
            this.val = val;
            this.bitVal = bitVal;
        }
    }
}
