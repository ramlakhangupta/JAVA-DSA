class Solution {
    public boolean checkDFS(HashMap<Integer, ArrayList<Integer>> map, boolean[] visited, int i, boolean[] recursion) {
        visited[i] = true;
        recursion[i] = true;

        for (int j : map.getOrDefault(i, new ArrayList<>())) {
            if (!visited[j] && checkDFS(map, visited, j, recursion)) {
                return true;
            } else if (recursion[j] == true) {
                return true;
            }
        }
        recursion[i] = false;
        return false;
    }

    

    public boolean canFinish(int n, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] a : prerequisites) {
            map.computeIfAbsent(a[1] , k -> new ArrayList<>()).add(a[0]);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] && checkDFS(map, visited, i, new boolean[n])) {
                return false;
            }
        }
        return true;
    }
}
