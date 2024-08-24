import java.util.HashMap;

public class validAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map1.containsKey(key)) {
                int frequency = map1.get(key);
                map1.put(key, frequency+1);
            }
            else {
                map1.put(key, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (map2.containsKey(key)) {
                int frequency = map2.get(key);
                map2.put(key, frequency+1);
            }
            else {
                map2.put(key, 1);
            }
        }

       for (char key : map1.keySet()) {
        int val1 = map1.get(key);
        if (!map2.containsKey(key)) {
            return false;
        }
        int val2 = map2.get(key);
        if (val1 != val2) {
            return false;
            
        }
       }
       return true;
       }


       public static void main(String[] args) {
        String s = "anagram";
        String t = "ramanag";
        boolean ans = isAnagram(s,t);
        System.out.println(ans);
       }
    }

