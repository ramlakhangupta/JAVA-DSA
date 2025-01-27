import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthesis241 {

    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> result = new ArrayList<>();

        //iterate through each character in string
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(s.substring(0,i));
                List<Integer> right = diffWaysToCompute(s.substring(i+1));

                //combine the result from left and right parts
                for(int x : left) {
                    for(int y : right) {
                        if(c == '+' ) {
                            result.add(x+y);
                        } else if(c == '-') {
                            result.add(x-y);
                        } else {
                            result.add(x*y);
                        }
                    }
                }
            } 
        }

        //if two operator is found, it means the string is a number
        if(result.isEmpty()) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    
}