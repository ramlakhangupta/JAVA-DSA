import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SDWithList {
    

    public List<String> serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root, list);
        return list;
    }



    private void helper(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            return ;
        }

        list.add(String.valueOf(root.val));

        helper(root.left, list);
        helper(root.right, list);
    }





    // Decodes your encoded data to tree.
    public TreeNode deserialize(List<String> list) {
        Collections.reverse(list);
        TreeNode node = helper2(list);
        return node;
    }



    private TreeNode helper2(List<String> list) {
       String val = list.remove(list.size() -1);

       if (val.charAt(0) == 'n') {
            return null;
       }

       TreeNode node = new TreeNode(Integer.parseInt(val));

       node.left = helper2(list);
       node.right = helper2(list);

       return node;

    }


}
