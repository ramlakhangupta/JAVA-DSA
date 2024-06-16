import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

  public class TreeNode {
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

public class levelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();

       if (root == null) {
         return result;
       }

       Queue<TreeNode> queue = new LinkedList<>();

       queue.offer(root); // offer likes a  add  function 
       //if you access the root of the tree then the whole tree can be accessed.
       while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // poll function as like as in stack peek function
                currentLevel.add(currentNode.val); 
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
       }


       return result;

       
    }
}