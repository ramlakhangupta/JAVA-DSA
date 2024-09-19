import java.util.*;

//recursion
public class DifferentWaysToAddParentheses241 {

    public List<Integer> diffWaysToCompute1(String str) {
        int n = str.length();
        
        return helper1(str, 0, n - 1);
    }

    public List<Integer> helper1(String str, int start, int end) {
        List<Integer> result = new ArrayList<>();
        // base case : single digit
        if (start == end) {
            int num = str.charAt(start) - '0';
            result.add(num);
            return result;
        }
        // base case : double digit
        if (end - start == 1 && Character.isDigit(str.charAt(start))) {
            // int num1 = str.charAt(start) -'0'; num1*10 + num2;
            // int num2 = str.charAt(end) - '0';
            int num = Integer.parseInt(str.substring(start, end + 1));
            result.add(num);
            return result;
        }
        // split
        for (int i = start; i <= end; i++) {
            if (Character.isDigit(str.charAt(i))) {
                continue;
            }
            char op = str.charAt(i);
            List<Integer> left = helper1(str, start, i - 1);
            List<Integer> right = helper1(str, i + 1, end);
            for (int l : left) {
                for (int r : right) {
                    if (op == '*') {
                        result.add(l * r);
                    } else if (op == '+') {
                        result.add(l + r);
                    } else {
                        result.add(l - r);
                    }
                }
            }
        }
        return result;
    }


    //RECURSION + MEMOIZATION
    public List<Integer> diffWaysToCompute(String str) {
        int n = str.length();
        List<Integer>[][] dp = new ArrayList[n][n];
        return helper(str, 0, n - 1, dp);
    }

    public List<Integer> helper(String str, int start, int end, List<Integer>[][] dp) {
        List<Integer> result = new ArrayList<>();
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        // base case : single digit
        if (start == end) {
            int num = str.charAt(start) - '0';
            result.add(num);
            return result;
        }
        // base case : double digit
        if (end - start == 1 && Character.isDigit(str.charAt(start))) {
            // int num1 = str.charAt(start) -'0'; num1*10 + num2;
            // int num2 = str.charAt(end) - '0';
            int num = Integer.parseInt(str.substring(start, end + 1));
            result.add(num);
            return result;
        }
        // split
        for (int i = start; i <= end; i++) {
            if (Character.isDigit(str.charAt(i))) {
                continue;
            }
            char op = str.charAt(i);
            List<Integer> left = helper(str, start, i - 1, dp);
            List<Integer> right = helper(str, i + 1, end, dp);
            for (int l : left) {
                for (int r : right) {
                    if (op == '*') {
                        result.add(l * r);
                    } else if (op == '+') {
                        result.add(l + r);
                    } else {
                        result.add(l - r);
                    }
                }
            }
        }
        dp[start][end] = result;
        return result;
    }
}