class Solution {
    int n;
    List<List<Integer>> dp;

    public List<Integer> solve(int i, ArrayList<Integer> list, ArrayList<Integer> curr, int[] nums) {
        if(i >= n) {
            if(list.size() < curr.size()) {
                list.clear();
                list.addAll(curr);
            }
            return list;
        }

        
        if(isCheck(curr, nums[i])) {
            curr.add(nums[i]);
            solve(i + 1, list, curr, nums);
            curr.remove(curr.size() - 1);
        }

        solve(i +1, list, curr, nums);

        return list;
    }

    public boolean isCheck(ArrayList<Integer> list, int val) {

        if(list.size() < 1) {
            return true;
        }

        if(list.get(list.size() -1) % val != 0 && val % list.get(list.size()-1) != 0) {
            return false;
        }
        return true;
    }


    public List<Integer> largestDivisibleSubset(int[] nums) {
        n = nums.length;
        dp = new ArrayList<>();
        Arrays.sort(nums);
        return solve(0, new ArrayList<>(), new ArrayList<>(), nums);
    }
} 


//bottom up
