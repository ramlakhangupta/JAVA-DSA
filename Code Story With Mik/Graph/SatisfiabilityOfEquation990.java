class Solution {

    public int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }

    public void union(int x_parent, int y_parent, int[] parent, int[] rank) {
        if (parent[x_parent] == parent[y_parent]) {
            return;
        }

        if (x_parent == y_parent)
            return; // Already connected

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        int[] parent = new int[26];
        int[] rank = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            if (equations[i].charAt(1) == '!') {
                continue;
            }

            int x_parent = find(equations[i].charAt(0) - 'a', parent);
            int y_parent = find(equations[i].charAt(3) - 'a', parent);
            union(x_parent, y_parent, parent, rank);
        }

        for (int i = 0; i < n; i++) {
            if (equations[i].charAt(1) == '!') {
                if (find(equations[i].charAt(0) - 'a', parent) == find(equations[i].charAt(3) - 'a', parent)) {
                    return false;
                }
            }
        }
        return true;
    }

}
