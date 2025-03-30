class Solution {
    public boolean checkDFS(int[][] graph, int i, int[] color, int currColor) {
        color[i] = currColor; //color bhar diya

        //ab connected vertex pe color bhar dete h chalo 
        for (int j : graph[i]) {
            if (color[j] == color[i]) {
                return false;
            }

            if (color[j] == -1) {
                int colorOfJ = 1 - currColor;
                if (checkDFS(graph, j, color, colorOfJ) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        //red = 1, green = 0;

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (checkDFS(graph, i, color, 1) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}
