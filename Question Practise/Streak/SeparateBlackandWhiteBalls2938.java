public class SeparateBlackandWhiteBalls2938 {

    //Brute Force (TLE) 
    public static long minimumSteps1(String s) {
        long count = 0;
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i] = Integer.parseInt(s.charAt(i) +"");
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) {
               if (i == 0 ) {
                    continue;
               } else if(ans[i] == 0 && ans[i-1] == 0) {
                    continue;
               } else {
                ans[i-1] = 0; 
                ans[i] = 1;
                count++;
                i = i-2;
           }
            } 
        }
        return count;
    }


    // good approach count only 1 regularly; 
    //T.C :  O(n)
    public static long minimumSteps2(String s) {
        long count = 0;
        int nOf1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count += nOf1;
            } else {
                nOf1++;
            }
        }
        return count;
    }


    //reverse approach see 0 and add by behind;
    //T.C :  O(n)
    public static long minimumSteps(String s) {
        int n = s.length();
        long swaps = 0;
        int white = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {  // Move black to the right
                swaps += white;
            } else {  // If it's white ('0'), increment white count
                white++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(minimumSteps("11000111"));
    }
}