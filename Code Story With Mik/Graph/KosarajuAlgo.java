public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        
        
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< V; i++) {
            if(visited[i]) {
                continue;
            }
            topologicalSort(adj, i, visited, stack);
        }
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>()); // 🔧 yeh line missing thi
        }


        for(int i =0; i<V; i++) {
            for(int j : adj.get(i)) {
                list.get(j).add(i);
            }
        }
        
        int count = 0;
        Arrays.fill(visited, false);
        
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(visited[top]) {
                continue;
            }
            DFS(list, top, visited);
            count++;
        }
        return count;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> list, int i, boolean[] visited) {
        visited[i] = true;
        
        for(int j : list.get(i)) {
            if(visited[j]){
                continue;
            }
            DFS(list, j, visited);
        }
        return ;
    }
    
    
    public void topologicalSort(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        
        for(int j : adj.get(i)) {
            if(visited[j]) {
                continue;
            }
            topologicalSort(adj, j, visited, stack);
        }
        stack.push(i);
        return ;
    }
