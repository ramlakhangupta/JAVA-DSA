class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topoSort(rowConditions, k);
        List<Integer> colOrder = topoSort(colConditions, k);

        //check cycle contains or not ??? 
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[][] {};
        }

        int[][] matrix = new int[k][k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(colOrder.get(i), i);
        }

        for (int i = 0; i < k; i++) {
            int element = rowOrder.get(i);
            if (map.containsKey(element)) {
                matrix[i][map.get(element)] = element;
            }
        }
        return matrix;
    }

    public List<Integer> topoSort(int[][] edges, int n) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n + 1];
        List<Integer> topoOrder = new ArrayList<>();

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.add(i);
                count++;
            }
        }

        while (!que.isEmpty()) {
            int u = que.poll();
            topoOrder.add(u);

            for (int v : map.getOrDefault(u, new ArrayList<>())) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    que.add(v);
                    count++;
                }
            }
        }

        if (count != n) {
            return new ArrayList<>();
        }
        return topoOrder;
    }
}
