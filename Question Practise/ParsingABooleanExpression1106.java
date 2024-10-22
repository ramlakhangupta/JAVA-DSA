import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParsingABooleanExpression1106 {
    //Approach (Using stack)
    //T.C : O(n)
    //S.C : O(n)
    private char solveOp(char op, List<Character> values) {
        if (op == '!') 
            return values.get(0) == 't' ? 'f' : 't';

        if (op == '&') 
            return values.stream().anyMatch(ch -> ch == 'f') ? 'f' : 't';

        if (op == '|') 
            return values.stream().anyMatch(ch -> ch == 't') ? 't' : 'f';

        return 't'; // Unreachable
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        int n = expression.length();
        
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',') continue;

            if (c == ')') {
                List<Character> values = new ArrayList<>();
                // Gather all values inside the parentheses
                while (stack.peek() != '(') {
                    values.add(stack.pop());
                }
                stack.pop();  // Remove '('
                char op = stack.pop();  // Get the operator
                stack.push(solveOp(op, values));  // Push the result back
            } else {
                stack.push(c);  // Push the character onto the stack
            }
        }
        return stack.peek() == 't';
    }
}

