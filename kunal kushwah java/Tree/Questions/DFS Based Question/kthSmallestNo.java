import java.util.ArrayList;
import java.util.List;

public class kthSmallestNo {
    

    public int kthSmallest(TreeNode root, int k) {
       
        ArrayList list = new ArrayList<>();
        inOrderTraversal(root,list);
        return (int) list.get(k - 1);

    }

    private void inOrderTraversal(TreeNode root, List<Integer> list) {
     
      if (root == null) {
        return ;
      }
       inOrderTraversal(root.left, list);
       
       list.add(root.val);
       inOrderTraversal(root.right, list);
    }

    
    //              "OR"



    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
          return -1;
        }

        int count = 0;
        if (count == k) {
          return root.val;
        }

        int left = kthSmallest(root.left, k);
        int right = kthSmallest(root.right, k);

        count += 1;

        return root;
    }

}
