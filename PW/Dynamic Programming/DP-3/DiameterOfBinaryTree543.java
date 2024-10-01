import java.util.HashMap;

public class DiameterOfBinaryTree543 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //Method - 1
    public int diameterOfBinaryTree1(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();
        return helper(root, dp);
    }

    public int helper(TreeNode root, HashMap<TreeNode, Integer> dp) {
        if (root == null)
            return 0;
        int rootDia = levels(root.left, dp) + levels(root.right, dp);
        int subLeft = helper(root.left, dp);
        int subRight = helper(root.right, dp);
        return Math.max(rootDia, Math.max(subLeft, subRight));
    }

    public int levels(TreeNode root, HashMap<TreeNode, Integer> dp) {
        if (root == null)
            return 0;
        if (dp.containsKey(root))
            return dp.get(root);
        int leftLevels = levels(root.left, dp);
        int rightLevels = levels(root.right, dp);
        dp.put(root, 1 + Math.max(leftLevels, rightLevels));
        return dp.get(root);
    }

    //Method - 2
    static int dia; // int[] dia = {0}; it means if you want to pass int as a argument then in int
                    // you have two option : 1. Wrapper class(int -> Integer, char -> Character ...
                    // ) 2. Create an array of size 1

    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        levels(root);
        return dia;
    }

    public int levels(TreeNode root) {
        if (root == null) return 0;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        int path = leftLevels + rightLevels; // extra
        dia = Math.max(dia, path); // extra
        return 1 + Math.max(leftLevels, rightLevels);
    }


    //Method - 3 
    public int diameterOfBinaryTree3(TreeNode root) {
        int[] dia = { 0 }; // int[] dia = {0}; it means if you want to pass int as a argument then in int
        // you have two option : 1. Wrapper class(int -> Integer, char -> Character ...
        // par isme apan ko khud se wrapper class likhni padegi)
        // ) 2. Create an array of size 1
        levels(root, dia);
        return dia[0];
    }

    public int levels(TreeNode root, int[] dia) {
        if (root == null)
            return 0;
        int leftLevels = levels(root.left, dia);
        int rightLevels = levels(root.right, dia);
        int path = leftLevels + rightLevels; // extra
        dia[0] = Math.max(dia[0], path); // extra
        return 1 + Math.max(leftLevels, rightLevels);
    }
}
