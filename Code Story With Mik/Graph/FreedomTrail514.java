class Solution {

    public int countSteps(int ringIndex, int i, int n) {
        int dist = Math.abs(i - ringIndex);
        int wrapAround = n - dist;

        return Math.min(dist, wrapAround);
    }

    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(ring.charAt(i))) {
                map.put(ring.charAt(i), new ArrayList<>());

            }
            map.get(ring.charAt(i)).add(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0, 0 });

        HashSet<String> visited = new HashSet<>();
        int totalSteps = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            totalSteps = top[0];
            int ringIndex = top[1];
            int keyIndex = top[2];

            if (keyIndex >= m) {
                break;
            }

            if (visited.contains(ringIndex + "-" + keyIndex)) {
                continue;
            }
            visited.add(ringIndex + "-" + keyIndex);

            for (int nextIndex : map.getOrDefault(key.charAt(keyIndex), new ArrayList<>())) {
                pq.add(new int[] { totalSteps + countSteps(ringIndex, nextIndex, n), nextIndex, keyIndex + 1 });
            }
        }
        return totalSteps + m;
    }
}
