public class LengthPalindromicSubstring5 {
    public static String longestPalindrome(String s) {
        int n = s.length();
        int a = 0, b = 0;
        String str = "";
        int[][] dp = new int[n][n];
        for (int k = 0; k < n; k++) {
            int count = 0;
            int len = 0;
            int i = 0, j = k;
            while (j < n) {
                if (i == j) {
                    dp[i][j] = 1;
                    count = dp[i][j];
                    if (count > len) {
                        a = i;
                        b = j;
                        len = count;
                    }
                } else if (j == i + 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 1;
                        count = dp[i][j];
                        if (count > len) {
                            a = i;
                            b = j;
                            len = count;
                        }
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (dp[i + 1][j - 1] > 0) {
                            dp[i][j] = dp[i + 1][j - 1] + 1;
                            count = dp[i][j];
                            if (count > len) {
                                a = i;
                                b = j;
                                len = count;
                            }
                        }
                    }
                }
                i++;
                j++;

            }
        }
        System.out.println(a);
        System.out.println(b);

        for(int i = a; i<=b ; i++){
            str += s.charAt(i);
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaa"));
    }
    
}
