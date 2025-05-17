class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] relation : relations) {
            map.computeIfAbsent(relation[0] - 1, key -> new ArrayList<>()).add(relation[1] - 1);
            indegree[relation[1] - 1]++;
        }

        int[] remTime = new int[n];
        Arrays.fill(remTime, 0);
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                que.add(i);
                remTime[i] = time[i];
            }
        }

        while (!que.isEmpty()) {
            int N = que.size();
            while (N > 0) {
                int top = que.poll();
                int t = time[top];
                for (int v : map.getOrDefault(top, new ArrayList<>())) {
                    indegree[v]--;
                    remTime[v] = Math.max(remTime[v], time[v] + remTime[top]);
                    if (indegree[v] == 0) {
                        que.add(v);
                    }
                }
                N--;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(remTime[i], ans);
        }
        return ans;
    }
}
