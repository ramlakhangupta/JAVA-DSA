class Solution {

    public void DFS(HashMap<Node, Node> map, Node node, Node cloneNode) {
        for (Node n : node.neighbors) {

            if (!map.containsKey(n)) {
                Node clone = new Node(n.val);
                map.put(n, clone);
                cloneNode.neighbors.add(clone);
                DFS(map, n, clone);
            } else {
                cloneNode.neighbors.add(map.get(n));
            }
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        //create clone of given node
        Node cloneNode = new Node(node.val);

        //Now, clone its neighbor and recursively their neighbor
        // but if a node reappears, then we need to access that cloned node So, store them in a map <Node*, Node*>

        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, cloneNode);
        DFS(map, node, cloneNode);

        return cloneNode;

    }

}
