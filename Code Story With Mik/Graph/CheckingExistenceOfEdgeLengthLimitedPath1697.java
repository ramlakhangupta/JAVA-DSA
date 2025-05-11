//TLE

class Solution {

    public boolean DFS(HashMap<Integer, List<int[]>> map, int u, boolean[] visited, int end, int target) {

        if (u == end) {
            return true;
        }
        visited[u] = true;

        for (int[] top : map.getOrDefault(u, new ArrayList<>())) {
            int v = top[0];
            int cost = top[1];
            if (!visited[v] && cost < target) {
                if (DFS(map, v, visited, end, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edgeList) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new int[] { edge[1], edge[2] });
            map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(new int[] { edge[0], edge[2] });
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int target = queries[i][2];
            boolean[] visited = new boolean[n];
            if (DFS(map, start, visited, end, target)) {
                ans[i] = true;
            } else {
                ans[i] = false;
            }
        }
        return ans;
    }
}


class Solution {

    public int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    public void union(int x, int y, int[] parent, int[] rank) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (x_parent == y_parent) {
            return;
        }

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int qLen = queries.length;
        boolean[] result = new boolean[qLen];
        int[][] queriesWithIndex = new int[qLen][4];

        for (int i = 0; i < qLen; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }

        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[2]));

        int j = 0;
        for (int[] query : queriesWithIndex) {
            int u = query[0];
            int v = query[1];
            int limit = query[2];
            int idx = query[3];

            while (j < edgeList.length && edgeList[j][2] < limit) {
                union(edgeList[j][0], edgeList[j][1], parent, rank);
                j++;
            }

            result[idx] = find(u, parent) == find(v, parent);

        }
        return result;

    }
}
