import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    

    List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> subsets(int[] nums) {

        n = nums.length;
        List<Integer> list = new ArrayList<>();
        solve(nums, 0, list);
        return result;

    }

    public void solve(int[] nums, int i, List<Integer> list) {
        // base condition
        if (i == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        solve(nums, i + 1, list);
        list.remove(list.size() - 1);
        solve(nums, i + 1, list);
    }
}
