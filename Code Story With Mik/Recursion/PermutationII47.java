import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PermutationII47 {
    HashSet<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            list.add(num);
        }

        solve(0, list);

        List<List<Integer>> result = new ArrayList<>(set);


        return result;
    }

    public void solve(int i, List<Integer> temp) {
        //base condition
        if(i == temp.size()) {
            if(!set.contains(temp)) {
                set.add(new ArrayList<>(temp));
            }
            return ;
        }

        for(int j=i; j<temp.size() ; j ++) {
            Collections.swap(temp, i, j);
            solve(i+1, temp);
            Collections.swap(temp, i, j);
        }
        
    }

    int n;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique1(int[] nums) {

        n = nums.length;

        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int freq = map.get(nums[i]);
                map.put(nums[i], freq + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        solve(list, map);
        return result;
    }

    public void solve(List<Integer> list, HashMap<Integer, Integer> map) {
        // base condition
        if (list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value == 0) {
                continue;
            }

            list.add(key);
            map.put(key, value - 1);

            solve(list, map);

            list.remove(list.size() - 1);
            map.put(key, value);
        }

    }
}
