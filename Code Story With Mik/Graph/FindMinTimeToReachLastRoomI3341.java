public static int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        result[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1];
            int j = top[2];
            int time = top[0];

            if(i == m-1 && j == n-1) {
                return result[m-1][n-1];
            }

            if(time > result[i][j]) {
                continue;
            }

        

            

            for(int[] dir : directions) {
                int newTime = time;
                int newi = i + dir[0];
                int newj = j + dir[1];

                if(newi >= 0 && newj >= 0 && newi < m && newj < n) {
                    int val = moveTime[newi][newj];
                    if(newTime < val) {
                        newTime = val;
                    }

                    if(newTime + 1 < result[newi][newj]) {
                        result[newi][newj] = newTime + 1;
                        pq.offer(new int[] {newTime + 1, newi, newj});
                    }
                }
            }
        }
        return result[m-1][n-1];
    }
