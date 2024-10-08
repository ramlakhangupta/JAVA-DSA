import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class permutation46 { 

    static List<List<Integer>> result;
    static HashSet<Integer> set ;
    public static List<List<Integer>> permute1(int[] nums) {
        set = new HashSet<>();
        result = new ArrayList<>();
        List<Integer> list = new  ArrayList<Integer>();
        solve1(list, nums);
        return result;
    }

    public static void solve1(List<Integer> list, int[] nums){
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                list.add(nums[i]);
                set.add(nums[i]);
                solve1(list, nums);

                list.remove(list.size()-1);
                set.remove(nums[i]);

            }
        }

    }

    //second approach by idx
    public static List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<List<Integer>>();
        solve(0, nums);
        return result;
    }

    public static void solve(int idx, int[] nums) {
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            solve(idx + 1, nums);
            swap(nums, i, idx);
        }
    }

    public static void swap(int[] nums, int i, int idx) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }




    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
       System.out.println( permute(nums));
    }
}
