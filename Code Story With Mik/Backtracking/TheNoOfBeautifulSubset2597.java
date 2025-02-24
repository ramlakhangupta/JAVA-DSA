class Solution {

    int result = 0;

    public void solve(int[] nums, int k, HashMap<Integer, Integer> map, int idx) {
        if (idx == nums.length) {
            result++;
            return;
        }
        // not take
        solve(nums, k, map, idx + 1);

        if (!map.containsKey(nums[idx] + k) && !map.containsKey(nums[idx] - k)) {
            map.put(nums[idx], map.getOrDefault(nums[idx], 0) + 1);
            solve(nums, k, map, idx + 1);
            map.put(nums[idx], map.get(nums[idx]) - 1);

            if (map.get(nums[idx]) == 0) {
                map.remove(nums[idx]);
            }
        }

    }

    public int beautifulSubsets(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        solve(nums, k, map, 0);

        return result - 1;
    }
}
