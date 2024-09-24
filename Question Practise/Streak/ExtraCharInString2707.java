
import java.util.*;

public class ExtraCharInString2707 {
     public static int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[50];
        Arrays.fill(dp, -1);
        
        return helper(s, set, 0, dp);

    }

    public static int helper(String s, HashSet<String> set, int index, int[] dp){
        if (index == s.length()) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        StringBuilder sb = new StringBuilder();
        int minExtraChar = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int extraChar = 0;
            if (!set.contains(sb.toString())) {
                extraChar = sb.length();
            }
            int curExtra = helper(s, set, i+1, dp);
            minExtraChar = Math.min(minExtraChar, extraChar+ curExtra);
        }
        return dp[index] = minExtraChar;
    }

    public static void main(String[] args) {
        String s = "dwmodizxvvbosxxw";
        String[] dictionary = {"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"};
        System.out.println(minExtraChar(s, dictionary));
    }
}
