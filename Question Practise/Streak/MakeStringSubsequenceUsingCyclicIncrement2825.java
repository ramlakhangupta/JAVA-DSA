
public class MakeStringSubsequenceUsingCyclicIncrement2825 {
   
    public static boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        if (n > m) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if ((str1.charAt(i) == str2.charAt(j)) || (str1.charAt(i) + 1 == str2.charAt(j))
                    || (str1.charAt(i) - 25 == str2.charAt(j))) {
                j++;
            }
            i++;
        }

        return j == n;
    }


    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ad";
        

        System.out.println(canMakeSubsequence(str1, str2) );

    }
}
