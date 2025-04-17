class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { entrance[0], entrance[1] });

        HashSet<String> visited = new HashSet<>();
        visited.add(entrance[0] + "," + entrance[1]);

        int exit = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!que.isEmpty()) {
            int n = que.size();

            while (n > 0) {
                int[] top = que.poll();
                int i = top[0];
                int j = top[1];

                if ((i == 0 || j == 0 || i == maze.length - 1 || j == maze[0].length - 1) && exit > 0) {
                    return exit;
                }

                for (int[] dir : directions) {
                    int new_i = dir[0] + i;
                    int new_j = dir[1] + j;

                    if (new_i >= 0 && new_j >= 0 && new_i < maze.length && new_j < maze[0].length
                            && maze[new_i][new_j] == '.' && !visited.contains(new_i + "," + new_j)) {
                        que.add(new int[] { new_i, new_j });
                        visited.add(new_i + "," + new_j);
                    }
                }
                n--;
            }
            exit++;
        }
        return -1;
    }
}
