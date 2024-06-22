import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class avgOfLevelInBinary {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while( !queue.isEmpty() ){
            int levelSize = queue.size();
           Double avg = (double) 0;
       
            for (int i = 0; i < levelSize; i++) {
            TreeNode currNode = queue.poll();
            avg += currNode.val;
            
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }

            
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }
       result.add(avg/levelSize);
    }
        return result;
        }

    

}
