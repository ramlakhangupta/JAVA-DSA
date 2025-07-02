class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int max_wt = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(new int[] { edge[0], edge[2] });
            max_wt = Math.max(max_wt, edge[2]);
        }

        int start = 0;
        int end = max_wt;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canWeReach(map, n, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public boolean canWeReach(HashMap<Integer, List<int[]>> map, int n, int mid) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { 0, 0 });
        boolean[] visited = new boolean[n];
        visited[0] = true;

        while (!que.isEmpty()) {
            int[] top = que.poll();
            int node = top[0];
            int wt = top[1];

            for (int[] neighbor : map.getOrDefault(node, new ArrayList<>())) {
                int currNode = neighbor[0];
                int currWt = neighbor[1];

                if (visited[currNode] || mid < currWt) {
                    continue;
                }
                visited[currNode] = true;
                que.add(new int[] { currNode, currWt });
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }
}
