public class LongestCommonSubSequence1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, text1.length()-1, text2.length()-1 );
    }

    public int helper(String text1, String text2, int t1end, int t2end){
        if (t1end < 0 ||t2end < 0) {
            return 0;
        }

       
        if(text1.charAt(t1end-1) == text2.charAt(t2end-1)){
             return 1 + helper(text1, text2, t1end-1, t2end-1);
        } else {
            Math.max(helper(text1, text2, t1end-1, t2end), helper(text1, text2, t1end, t2end-1));
        }
    
    }
}
