class Solution {
    public void checkBFS(int[][] isConnected, int i, boolean[] visited) {

        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        visited[i] = true;

        while (!que.isEmpty()) {
            int v = que.poll();

            for (int j = 0; j < isConnected.length; j++) {
                if (!visited[j] && isConnected[v][j] == 1) {
                    que.add(j);
                    visited[j] = true;
                }
            }
        }

    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                checkBFS(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }
}
