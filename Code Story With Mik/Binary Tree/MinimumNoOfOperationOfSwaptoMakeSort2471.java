
class Solution {
    public int countMinSwapsToSort(List<Integer> list) {
        int swaps = 0;
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(sortedList.get(i))) {
                continue;
            }

            int currIdx = map.get(sortedList.get(i));
            map.put(list.get(i), currIdx);
            map.put(list.get(currIdx), i);

            Collections.swap(list, currIdx, i);
            swaps++;
        }
        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int ans = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> list = new ArrayList<>();

            while (n > 0) {
                TreeNode node = que.poll();
                list.add(node.val);

                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
                n--;
            }
            ans += countMinSwapsToSort(list);
        }
        return ans;
    }
}
