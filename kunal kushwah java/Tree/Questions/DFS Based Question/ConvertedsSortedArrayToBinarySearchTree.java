
public class ConvertedsSortedArrayToBinarySearchTree {
    

    public TreeNode sortedArrayToBST(int[] nums) {

       
        return sortedArray(nums,0, nums.length-1);
    }

    private TreeNode sortedArray(int[] nums, int start, int end) {
       
        if (start > end) {
            return null;
        }
       

        int mid = (start+end) /2 ;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = sortedArray(nums, start, mid-1);
        node.right = sortedArray(nums, mid + 1, end);

       return node;
    }
}
