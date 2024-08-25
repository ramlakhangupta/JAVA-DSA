import java.util.HashMap;


public class longestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int maxLength = 0;
        int i= 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < n) {
            char ch = s.charAt(j);
            if (map.containsKey(ch) && map.get(ch) >= i) {
                int len = j-i;
                maxLength = Math.max(maxLength, len);
                //i ko leke jao ch ki purani position se aage
                while (s.charAt(i) != ch) i++;
                i++; // ek aage nikalan hai 
            }
            map.put(ch, j);
            j++;
        }
        return maxLength;
    }

}
