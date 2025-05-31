class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] { 0, 1 });
        int[] ans1 = new int[n + 1];
        int[] ans2 = new int[n + 1];

        Arrays.fill(ans1, Integer.MAX_VALUE);
        Arrays.fill(ans2, Integer.MAX_VALUE);

        ans1[1] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int passedTime = top[0];
            int node = top[1];

            if (node == n && ans2[node] != Integer.MAX_VALUE) {
                return ans2[node];
            }

            int mult = passedTime / change;
            if (mult % 2 == 1) { // Red light
                passedTime = change * (mult + 1); // to set green
            }

            for (int neighbor : map.getOrDefault(node, new ArrayList<>())) {

                if (passedTime + time < ans1[neighbor]) {
                    ans2[neighbor] = ans1[neighbor];
                    ans1[neighbor] = passedTime + time;
                    pq.add(new int[] { passedTime + time, neighbor });
                    continue;
                } else if (passedTime + time < ans2[neighbor]  && ans1[neighbor] != passedTime + time) {
                    ans2[neighbor] = passedTime + time;
                    pq.add(new int[] { passedTime + time, neighbor });
                }
            }
        }
        return ans2[n];
    }
}
