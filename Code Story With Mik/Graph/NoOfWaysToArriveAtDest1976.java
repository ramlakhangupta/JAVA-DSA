class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], key -> new ArrayList<>()).add(new int[] { road[1], road[2] });
            map.computeIfAbsent(road[1], key -> new ArrayList<>()).add(new int[] { road[0], road[2] });
        }

        long[] result = new long[n];
        int[] size = new int[n];
        Arrays.fill(result, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        result[0] = 0;
        size[0] = 1;
        pq.offer(new long[] { 0, 0 }); // time, value

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long time = top[0];
            int node = (int) top[1];

            if (time > result[node])
                continue;

            for (int[] neighbor : map.getOrDefault(node, new ArrayList<>())) {
                int currTime = neighbor[1];
                int currNode = neighbor[0];

                if (currTime + time < result[currNode]) {
                    result[currNode] = currTime + time;
                    pq.offer(new long[] { currTime + time, currNode });
                    size[currNode] = size[node];
                } else if (currTime + time == result[currNode]) {
                    size[currNode] = (size[currNode] + size[node]) % MOD;
                }
            }
        }
        return size[n - 1];
    }

}
