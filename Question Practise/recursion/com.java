import java.util.List;
import java.util.ArrayList;

public class com {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }

     public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), candidates, 0, target);
        return list;
    }

    public static void helper(List<List<Integer>> list, List<Integer> temp, int[] candidates, int start, int target){

        //base condition
        if(target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }

        //recursion step
        for (int i = start; i < candidates.length; i++) {
            if(target < candidates[i]){
                continue;
            }
            temp.add(candidates[i]);
            helper(list, temp, candidates, i, target-candidates[i]);
            temp.remove(temp.size() -1);
        }
    }
}
