import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Petmutation46 {

    List<List<Integer>> result = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, temp);
        return result;
    }

    public void solve(int[] nums, List<Integer> temp) {
        // base condition
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                temp.add(nums[i]);
                set.add(nums[i]);

                solve(nums, temp);

                temp.remove(temp.size() - 1);
                set.remove(nums[i]);
            }
        }
    }

    
}