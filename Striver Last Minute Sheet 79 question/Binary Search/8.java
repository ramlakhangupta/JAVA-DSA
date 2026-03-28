/////////////////////////////////////////////////        BRUTE FORCE        //////////////////////////////////////////////

/////////////////////////////////////////////////        OPTIMIZED        //////////////////////////////////////////////
class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        //Base Condition
        if (n == 0 || Character.isLowerCase(s.charAt(0)) || Character.isUpperCase(s.charAt(0)) || s.charAt(0) == '.') {
            return 0;
        }

        //all space remove
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }

        long ans = 0;
        int index = i;
        char sign = ' ';
        boolean number = false;
        while (i < n) {
            char ch = s.charAt(i);

            if (index == i && (ch == '-' || ch == '+')) {
                sign = ch;
            } else if (!number && ch == '0') {
                i++;
                continue;
            } else if (Character.isDigit(ch)) {
                if (ans > (Integer.MAX_VALUE - (ch - '0')) / 10) {
                    return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10 + (ch - '0');
                number = true;
            } else {
                break;
            }
            i++;

        }
        if (sign == '-') {
            ans = 0 - ans;
        }

        return (int) ans;
    }
}
