import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
  
              if (root == null) {
                  return result;
              }
  
              Queue<TreeNode> queue = new LinkedList<>();
  
              queue.offer(root);
  
              while ( !queue.isEmpty() ) {
                  int levelSize = queue.size();
                  List<Integer> currLevel = new ArrayList<>(levelSize);
                  for (int i = 0; i < levelSize; i++) {
                      TreeNode currNode = queue.poll();
                      currLevel.add(currNode.val); 
  
                      if (currNode.left != null) {
                          queue.offer(currNode.left);
                      }
  
                      if (currNode.right != null) {
                          queue.offer(currNode.right);
                      }
  
                  }
  
                  result.add(0, currLevel);
  
  
  
              }
  
              return result;
  
      }
}