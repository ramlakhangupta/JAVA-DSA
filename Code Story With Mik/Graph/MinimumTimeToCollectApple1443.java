class Solution {
    public int checkDFS(HashMap<Integer, List<Integer>> map, int curr, int parent, List<Boolean> hasApple) {

        int time = 0;

        for (int child : map.getOrDefault(curr, new ArrayList<>())) {
            if (child == parent)
                continue;

            int time_from_child = checkDFS(map, child, curr, hasApple);

            if (time_from_child > 0 || hasApple.get(child) == true) {
                time += time_from_child + 2;
            }
        }
        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        return checkDFS(map, 0, -1, hasApple);
    }
}
