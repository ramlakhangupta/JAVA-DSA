import java.util.*;
public class subsets78 {

  public static void main(String[] args) {
    int[] arr = {1,2,3,4};
    ArrayList<Integer> ans = new ArrayList<>();
    subset(arr, 0, ans);
  }

  public static void subset(int[] arr, int i, ArrayList<Integer> ans){
    if(arr.length == i) {
        System.out.println(ans);
        return ;
    }
    subset( arr , i+1, ans);
    ans.add(arr[i]);
    subset(arr, i+1, ans);
    ans.remove(ans.size()-1);
  }



  public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        helper(nums, 0, ans);
        List<List<Integer>> ans2 = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j = i; j < i + ans.size() && j < ans.size(); j++) {
                sub.add(ans.get(j));
            }
            ans2.add(sub);
        }
        return ans2;
  }

  public List<Integer> helper(int[] arr, int i, List<Integer> ans){
    if(arr.length == i) {
        return ans;
    }
    helper( arr , i+1, ans);
    ans.add(arr[i]);
    helper(arr, i+1, ans);
    ans.remove(ans.size()-1);

    return ans;
  }
}