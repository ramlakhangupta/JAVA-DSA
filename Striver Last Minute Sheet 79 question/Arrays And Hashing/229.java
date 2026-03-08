///////////////////////////////////    BRUTE FORCE   ////////////////////////////////
public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int value = map.get(num);
                map.put(num, value + 1);
            }
        }

        int times = n / 3;
        List<Integer> ans = new ArrayList<>();
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            if (val > times) {
                ans.add(key);
            }
        }

        return ans;
}



//////////////////////////////////////////////    OPTIMIZED BY Boyer-Moore Voting Algorithm    //////////////////////////////////////
public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        int candidate_one = 0;
        int candidate_one_iteration = 0;
        int candidate_two = 0;
        int candidate_two_iteration = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            if (val == candidate_one) {
                candidate_one_iteration++;
            } else if (val == candidate_two) {
                candidate_two_iteration++;
            } else if (candidate_one_iteration == 0) {
                candidate_one = val;
                candidate_one_iteration = 1;
            } else if (candidate_two_iteration == 0) {
                candidate_two = val;
                candidate_two_iteration = 1;
            } else {
                candidate_one_iteration--;
                candidate_two_iteration--;
            }
        }

        candidate_one_iteration = 0;
        candidate_two_iteration = 0;
        for (int num : nums) {
            if (num == candidate_one) {
                candidate_one_iteration++;
            } else if (num == candidate_two) {
                candidate_two_iteration++;
            }
        }

        int check = n / 3;
        if (candidate_one_iteration > check) {
            ans.add(candidate_one);
        }

        if (candidate_two_iteration > check) {
            ans.add(candidate_two);
        }

        return ans;
    }
