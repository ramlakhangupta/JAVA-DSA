public class ShortestPalindrome214 {

    public static String shortestPalindrome(String s) {
        StringBuilder reversedStr = new StringBuilder(s).reverse();
        
        String combined = s + "#" + reversedStr;
        
        int[] kmp = new int[combined.length()];
        
        // Build the KMP table
        for (int i = 1; i < combined.length(); i++) {
            int j = kmp[i - 1];
            
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = kmp[j - 1];
            }
            
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            
            kmp[i] = j;
        }
        
        // The part to add is the reversed substring after the matched palindrome
        String suffixToAdd = reversedStr.substring(0, s.length() - kmp[combined.length() - 1]);
        
        return suffixToAdd + s;
    }
    

    public static void main(String[] args) {
        String str = "aabba";
        System.out.println(shortestPalindrome(str));
    }
}