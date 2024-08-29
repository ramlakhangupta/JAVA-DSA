import java.util.HashMap;
import java.util.HashSet;

public class uniqueLength {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character, Integer> fmap = new HashMap<>();
        HashMap<Character, Integer> lmap = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            lmap.put(key, i);
        }
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (!fmap.containsKey(key)) {
                fmap.put(key, i);
            } 
        }

        for(char ch : fmap.keySet()) {
            int firstIdx = fmap.get(ch);
            int lastIdx = lmap.get(ch);
            HashSet<Character> set = new HashSet<Character>();
            for(int i = firstIdx+1; i <= lastIdx-1; i++) {
                set.add(s.charAt(i));
            }
            count += set.size();
        }
        return count;


    }
}
