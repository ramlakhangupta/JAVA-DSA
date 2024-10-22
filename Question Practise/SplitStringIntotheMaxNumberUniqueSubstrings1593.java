import java.util.HashMap;
import java.util.HashSet;

public class SplitStringIntotheMaxNumberUniqueSubstrings1593 {
    

    //by this code 75 test cases are passing but not complete for this testcase "wwwzfvedwfvhsww" it would be failed
    //using HashTable
    public static int maxUniqueSplit1(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for(int i=0; i<s.length(); i++){
            String ch = s.charAt(i)+"" ;
            if(!map.containsKey(ch)){
                map.put(ch , 1);
                count++;
            } else {
                int j = i+1;
                String temp = ch;
                int len = map.size()+1;
                while(j<s.length() && map.size() != len){
                    temp += s.charAt(j) + "";
                    if(!map.containsKey(temp)){
                        map.put(temp, 1);
                        count++;
                        
                    }
                    j++;
                    i++;
                }
            }
        }
        
        return count;
    }

    //Approach (Using simple backtracking)
    //T.C : O(n*2^n)
    //S.C : O(n)
    private static void solve(String s, int idx, HashSet<String> st, int currCount, int[] maxCount) {
        // Pruning for slight improvement
        if(currCount + (s.length() - idx) <= maxCount[0]) {
            return;
        }

        if (idx == s.length()) {
            maxCount[0] = Math.max(maxCount[0], currCount);
            return;
        }

        for (int j = idx; j < s.length(); j++) {
            String sub = s.substring(idx, j + 1);
            if (!st.contains(sub)) {
                st.add(sub);
                solve(s, j + 1, st, currCount + 1, maxCount);
                st.remove(sub);
            }
        }
    }

    public static int maxUniqueSplit(String s) {
        HashSet<String> st = new HashSet<>();
        int[] maxCount = new int[1]; // Using array to allow updates by reference
        solve(s, 0, st, 0, maxCount);
        return maxCount[0];
    }


    public static void main(String[] args) {
        maxUniqueSplit("wwwzfvedwfvhsww");
    }
}
