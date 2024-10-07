public class PermutationInString567 {

    //chatgpt 
    public static boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // Create frequency map for characters in s1
        int[] s1Freq = new int[26];
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Initialize a sliding window for s2 of size s1.length()
        int[] s2Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s2Freq[s2.charAt(i) - 'a']++;
        }

        // Check if the first window is a permutation
        if (matches (s1Freq, s2Freq)) return true;

        // Now slide the window across s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add the current character to the window
            s2Freq[s2.charAt(i) - 'a']++;

            // Remove the character that is no longer in the window
            s2Freq[s2.charAt(i - s1.length()) - 'a']--;

            // Check if current window matches
            if (matches(s1Freq, s2Freq)) return true;
        }

        return false;
    }

    private static boolean matches(int[] s1Freq, int[] s2Freq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }
        return true;
    }


    //Normal
    public boolean checkInclusion2(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        if (m<n) {
            return false;
        }

        int map1[] = new int[26];

        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= m-n; i++) {
            int map2[] = new int[26];
            for (int j = 0; j < n; j++) {
                map2[s2.charAt(i+j) - 'a']++;
            }
            if (isSame(map1, map2)) {
                return true;
            }

        }
        return false;
    }

    private static boolean isSame(int[] map1, int[] map2){
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
            
        }
        return true;
    }


    //optimize
    public static boolean checkInclusion(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        if (m<n) return false;

        int map1[] = new int[26];
        int map2[] = new int[26];

        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        //init window
        if (isSame(map1, map2)) {
            return true;
        }
        for (int i = 1; i <= m-n; i++) {
            map2[s2.charAt(i-1) - 'a']--;
            map2[s2.charAt(i+n-1) - 'a']++;

            if (isSame(map1, map2)) {
                return true;
            }

        }
        return false;
    }

    




    public static void main(String[] args) {
        System.out.println(checkInclusion1("hello", "ooolleoooleh"));
    }
}