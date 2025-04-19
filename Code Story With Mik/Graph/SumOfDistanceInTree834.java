class Solution {

    long resultBaseNode = 0;
    int N;
    int[] count;

    public int dfsBase(HashMap<Integer, List<Integer>> map, int currNode, int prevNode, int currDepth) {
        int totalNodes = 1;
        resultBaseNode += currDepth;

        for (int child : map.getOrDefault(currNode, new ArrayList<>())) {
            if (child == prevNode)
                continue;
            totalNodes += dfsBase(map, child, currNode, currDepth + 1);
        }

        count[currNode] = totalNodes;
        return totalNodes;
    }

    public void dfs(HashMap<Integer, List<Integer>> map, int parentNode, int prevNode, int[] result) {
        for (int child : map.getOrDefault(parentNode, new ArrayList<>())) {
            if (child == prevNode)
                continue;

            result[child] = result[parentNode] - count[child] + (N - count[child]);
            dfs(map, child, parentNode, result);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        count = new int[n];
        resultBaseNode = 0;
        N = n;

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        dfsBase(map, 0, -1, 0);

        int[] result = new int[n];
        result[0] = (int) resultBaseNode;

        dfs(map, 0, -1, result);

        return result;
    }
}
