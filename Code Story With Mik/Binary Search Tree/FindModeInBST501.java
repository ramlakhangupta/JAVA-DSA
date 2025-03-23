
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxIndex = 1;

    public void solve(TreeNode root) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(root.val)) {
            map.put(root.val, 1);

        } else {
            int freq = map.get(root.val);
            map.put(root.val, freq + 1);
            if (maxIndex < freq + 1) {
                maxIndex = freq + 1;
            }
        }

        solve(root.left);
        solve(root.right);
    }

    public int[] findMode(TreeNode root) {
        solve(root);
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (maxIndex == map.get(key)) {
                list.add(key);
            }
        }
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}
