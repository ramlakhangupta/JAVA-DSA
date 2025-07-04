class Solution {

    public static boolean fillbobQue(HashMap<Integer, List<Integer>> map, int bob, HashMap<Integer, Integer> bobQue,
            boolean[] visited, int level) {

        visited[bob] = true;

        if (bob == 0) {
            return true;
        }

        for (int neighbor : map.getOrDefault(bob, new ArrayList<>())) {
            if (!visited[neighbor] && fillbobQue(map, neighbor, bobQue, visited, level + 1)) {
                bobQue.put(neighbor, level);
                return true;
            }
        }
        return false;
    }

    public static int DFS(HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> bobQue, boolean[] visited,
            int[] amount, int i, int cost, int level) {
        visited[i] = true;

        int bobLevel = bobQue.getOrDefault(i, Integer.MAX_VALUE);
        if (level < bobLevel) {
            cost += amount[i];
        } else if (level == bobLevel) {
            cost += (amount[i] / 2);
        }

        int maxCost = Integer.MIN_VALUE;
        boolean leaf = true;

        for (int neighbor : map.getOrDefault(i, new ArrayList<>())) {
            if (!visited[neighbor]) {
                leaf = false;
                maxCost = Math.max(maxCost, DFS(map, bobQue, visited, amount, neighbor, cost, level + 1));
            }
        }

        if (leaf) {
            return cost;
        }

        return maxCost;

    }

    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        HashMap<Integer, Integer> bobQue = new HashMap<>();
        bobQue.put(bob, 0);
        fillbobQue(map, bob, bobQue, new boolean[n], 1);

        return DFS(map, bobQue, new boolean[n], amount, 0, 0, 0);
    }
}
