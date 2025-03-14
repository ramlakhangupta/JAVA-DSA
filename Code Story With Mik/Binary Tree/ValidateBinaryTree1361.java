class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> childToParent = new HashMap<>();
        HashMap<Integer, List<Integer>> parentToChildren = new HashMap<>();

        // Step 1: Build Parent-Child Mapping
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if (left != -1) {
                if (childToParent.containsKey(left))
                    return false; // Multiple parents case
                childToParent.put(left, i);
                parentToChildren.computeIfAbsent(i, k -> new ArrayList<>()).add(left);
            }
            if (right != -1) {
                if (childToParent.containsKey(right))
                    return false; // Multiple parents case
                childToParent.put(right, i);
                parentToChildren.computeIfAbsent(i, k -> new ArrayList<>()).add(right);
            }
        }

        // Step 2: Find Root Node
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!childToParent.containsKey(i)) { // Node without parent is root
                if (root != -1)
                    return false; // More than 1 root found
                root = i;
            }
        }
        if (root == -1)
            return false; // No root found

        // Step 3: BFS Traversal to Check Connectivity
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child : parentToChildren.getOrDefault(node, Collections.emptyList())) {
                if (visited[child])
                    return false; // Cycle detected
                visited[child] = true;
                queue.add(child);
                count++;
            }
        }

        return count == n;
    }
}
