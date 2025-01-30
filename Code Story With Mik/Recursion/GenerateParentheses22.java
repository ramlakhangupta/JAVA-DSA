import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
        List<String> result = new ArrayList<>();
    
        public List<String> generateParenthesis(int n) {
            solve("", n);
            return result;
        }
    
        private boolean isValid(String str) {
            int count = 0;
    
            char[] charArray = str.toCharArray();
    
            for (char ch : charArray) {
                if (ch == '(') {
                    count++;
                } else {
                    count--;
                    if (count < 0) {
                        return false;
                    }
                }
    
            }
            return count == 0;
        }
    
        public void solve(String str, int n) {
            if (str.length() == 2 * n) {
                if (isValid(str)) {
                    result.add(str);
                }
                return;
            }
    
            str += "(";
            solve(str, n);
            str = str.substring(0, str.length() - 1);
    
            str += ")";
            solve(str, n);
            str = str.substring(0, str.length() - 1);
        }
    
    

        public List<String> generateParenthesis1(int n) {
            solve1("", n, 0, 0);
            return result;
        }
    
        public void solve1(String str, int n, int open, int close) {
            if (str.length() == 2 * n) {
                result.add(str);
                return;
            }
    
            if (open < n) {
                str += "(";
                solve1(str, n, open + 1, close);
                str = str.substring(0, str.length() - 1);
    
            }
            if (close < open) {
                str += ")";
                solve1(str, n, open, close + 1);
                str = str.substring(0, str.length() - 1);
            }
        }

}
