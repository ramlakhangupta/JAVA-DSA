class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.computeIfAbsent(time[0], i -> new ArrayList<>()).add(new int[] { time[1], time[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[k] = 0;
        pq.add(new int[] { 0, k });

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[1];
            int d = top[0];

            for (int[] neighbor : map.getOrDefault(node, new ArrayList<>())) {
                int adjNode = neighbor[0];
                int w = neighbor[1];

                if (w + d < result[adjNode]) {
                    result[adjNode] = w + d;
                    pq.add(new int[] { w + d, adjNode });
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (result[i] != Integer.MAX_VALUE) {
                ans = Math.max(ans, result[i]);
            } else {
                return -1;
            }
        }

        return ans;
    }
}
