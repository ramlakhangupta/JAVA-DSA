class Solution {
    public int[][] validArrangement(int[][] pairs) {

        int V = pairs.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, Integer> outdegree = new HashMap<>();

        for (int[] pair : pairs) {
            int x = pair[0];
            int y = pair[1];

            map.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            outdegree.put(x, outdegree.getOrDefault(x, 0) + 1);
            indegree.put(y, indegree.getOrDefault(y, 0) + 1);
        }

        //step 2 find start node 
        int startNode = pairs[0][0];
        for (int node : map.keySet()) {
            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        //step 3 perform dfs
        List<Integer> eulerPath = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int curr = stack.peek();
            if (map.containsKey(curr) && !map.get(curr).isEmpty()) {
                int neighbor = map.getOrDefault(curr, new ArrayList<>()).remove(map.get(curr).size() - 1);
                stack.push(neighbor);
            } else {
                eulerPath.add(curr);
                stack.pop();
            }
        }

        //step 4 : build the result from the euler path
        Collections.reverse(eulerPath);
        int[][] result = new int[eulerPath.size() - 1][2];
        for (int i = 0; i < eulerPath.size() - 1; i++) {
            result[i][0] = eulerPath.get(i);
            result[i][1] = eulerPath.get(i + 1);
        }
        return result;
    }
}
