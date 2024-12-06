import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }


public class CousinsBinaryTreeii2641 {
    
    //Approach-1 (2 Pass)
    //T.C : O(2*n)
    //S.C : O(n)
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> levelSum = new ArrayList<>();

        // Step-1: Find the sum of each level and store it in the levelSum list
        while (!queue.isEmpty()) {
            int currLevelSum = 0;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                currLevelSum += curr.val;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            levelSum.add(currLevelSum);
        }

        // Step-2: Update each node value with the cousin sum
        queue.add(root);
        root.val = 0;  // root has no cousins
        int level = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();

                // levelSum of currentLevel - siblingSum
                int siblingSum = (curr.left != null ? curr.left.val : 0) + (curr.right != null ? curr.right.val : 0);

                if (curr.left != null) {
                    curr.left.val = levelSum.get(level) - siblingSum;
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = levelSum.get(level) - siblingSum;
                    queue.add(curr.right);
                }
            }
            level++;
        }

        return root;
    }



    //Approach-2 (1 Pass)
    //T.C : O(n)
    //S.C : O(n)
    public TreeNode replaceValueInTree1(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSum = root.val;

        while (!queue.isEmpty()) {
            int n = queue.size();
            int nextLevelSum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();

                // Update current node value
                curr.val = levelSum - curr.val;

                int siblingSum = (curr.left != null ? curr.left.val : 0) +
                                 (curr.right != null ? curr.right.val : 0);

                // Process left child
                if (curr.left != null) {
                    nextLevelSum += curr.left.val;
                    curr.left.val = siblingSum;
                    queue.add(curr.left);
                }

                // Process right child
                if (curr.right != null) {
                    nextLevelSum += curr.right.val;
                    curr.right.val = siblingSum;
                    queue.add(curr.right);
                }
            }

            // Move to the next level
            levelSum = nextLevelSum;
        }

        return root;
    }
}

