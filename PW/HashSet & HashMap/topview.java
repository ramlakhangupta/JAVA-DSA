//HackerRank Top View Tree

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;



public class topview {

    class Node {
        Node left;
        Node right;
        int data;
        
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public class pair {
        Node node;
        int level;
        pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    public static void topView(Node root) {
        HashMap<Integer,  Integer> map = new HashMap<>();
        Queue<pair> q = new LinkedList<>();
        pair r = new pair(root, 0);
        q.add(r);
        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;
        while(q.size() > 0) {
            pair temp = q.remove();
            Node n = temp.node;
            int lvl = temp.level;
            minLevel = Math.min(maxLevel,lvl);
            maxLevel = Math.max(maxLevel,lvl);

            if (!map.containsKey(lvl)) {
                map.put(lvl, n.data);
            }
            if (n.left != null) {
                q.add(new pair(n.left, lvl - 1));

            }
            if (n.right != null) {
                q.add(new pair(n.right, lvl + 1));
            }
        }
        for (int i = minLevel; i < maxLevel; i++) {
            System.out.println(map.get(i) + " ");
        }
    }
}
