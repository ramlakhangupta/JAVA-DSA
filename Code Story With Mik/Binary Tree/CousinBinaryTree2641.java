/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();

    public void sum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 0;
        while(que.isEmpty()) {
            int sum = 0;
            int n = que.size();
            while(n > 0) {
                TreeNode node = que.poll();
                sum += node.val;

                if(node.left != null) {
                    que.add(node.left);
                }
                if(node.right != null) {
                    que.add(node.right);
                }
                n--;
            }
            level++;
            map.put(level, sum);
        }
        return ;
    }

    public int solve(TreeNode root, int level) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return root.val;
        }

        int left = solve(root.left, level+1);
        int right = solve(root.right, level+1);

        int sum = map.get(level+1) - (left + right);

        if(root.left != null ){
            root.left.val = sum;
        }

        if(root.right != null ){
            root.right.val = sum;
        }
        return root.val;
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        sum(root);
        solve(root, 1);
        return root;
    }
}
