import java.util.*;

public class lengthOfLongestSubsequenceThatSumsToTarget2915 {
    public static int lengthOfLongestSubsequence(List<Integer> list, int target) {
        return helper(list,target,0,0);
    }

    public static int helper(List<Integer> list, int target, int i, int sum) {
        if(i == list.size()){
            if(sum == target){
                return 1;
            } else {
                return -1;
            }
        }
        int skip = helper(list,target,i+1,sum);
        if(sum > target){
            return skip;
        }
        int pick = helper(list,target, i+1, sum + list.get(i));

        return  Math.max(skip,pick);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int target = 9;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(lengthOfLongestSubsequence(list, target));
    }
    
}