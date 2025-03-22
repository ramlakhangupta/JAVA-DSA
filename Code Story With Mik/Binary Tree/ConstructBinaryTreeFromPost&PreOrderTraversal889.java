
class Solution {

    public TreeNode solve(int[] preorder, int[] postorder, int preStart, int postStart, int preEnd,
            HashMap<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int nextNode = preorder[preStart + 1]; // left subtree ka root

        // find it in postorder

        int j = map.get(nextNode);
        int num = j - postStart + 1;

        root.left = solve(preorder, postorder, preStart + 1, postStart, preStart + num, map);
        root.right = solve(preorder, postorder, preStart + num + 1, j + 1, preEnd, map);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return solve(preorder, postorder, 0, 0, preorder.length - 1, map);
    }
}
