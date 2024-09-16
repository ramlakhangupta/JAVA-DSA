import java.util.*;
public class longestSubstringContainVowel1371 {
        public static int findTheLongestSubstring(String s) {
            // HashMap to store the first occurrence of each vowel state
            HashMap<Integer, Integer> map = new HashMap<>();
            int state = 0; // bitmask representing the state of vowels
            map.put(state, -1); // initial state before any characters processed
            int count = 0;
    
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
    
                // Update the state if the character is a vowel
                if (ch == 'a') {
                    state ^= (1 << 0); // Toggle the first bit (a)
                } else if (ch == 'e') {
                    state ^= (1 << 1); // Toggle the second bit (e)
                } else if (ch == 'i') {
                    state ^= (1 << 2); // Toggle the third bit (i)
                } else if (ch == 'o') {
                    state ^= (1 << 3); // Toggle the fourth bit (o)
                } else if (ch == 'u') {
                    state ^= (1 << 4); // Toggle the fifth bit (u)
                }
    
                // If the state has been seen before, calculate the length of the substring
                if (map.containsKey(state)) {
                    count = Math.max(count, i - map.get(state));
                } else {
                    map.put(state, i); // Store the first occurrence of the state
                }
            }
    
            return count;
        }

    public static void main(String[] args) {
        String s = "leetcodeisgreat";
        System.out.println(findTheLongestSubstring(s));
    }
}