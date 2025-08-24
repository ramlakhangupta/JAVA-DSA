class Solution {
    long MOD = 1000000007;

    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = n - 1; j >= 0; j--) {
            if (!map.containsKey(nums[j])) {
                map.put(nums[j], j);
            }
        }

        int i = 0;
        int j = Math.max(0, map.get(nums[0]));

        int result = 1;
        while (i < n) {
            if (i > j) {
                result = (int) ((result * 2L) % MOD);
            }

            j = Math.max(j, map.get(nums[i]));
            i++;
        }

        return result;
    }

}
