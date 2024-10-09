import java.util.Stack;
public class MinimumNoSwapToMakeString1963 {
    public int minSwaps1(String s) {
        Stack<Character> stack = new Stack<>();

        // Traverse through the string
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch); // Push opening brackets to the stack
            } else if (!stack.isEmpty()) {
                stack.pop(); // Pop a matching opening bracket for each closing bracket
            }
        }

        // The remaining elements in the stack are unmatched '[' brackets
        // The number of swaps needed is half the number of unmatched brackets
        return (stack.size() + 1) / 2;
    }


    public static void main(String[] args) {
        System.out.println(minSwaps("]][]][][["));
    }
    
    public static int minSwaps2(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '['){
                st.push(s.charAt(i));
            } else if(!st.isEmpty()){
                st.pop();
            }
        }
         int ans  = (st.size()+1)/2;
         return ans;
    }

    public static int minSwaps(String s) {
        int size = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') size++;
            else if(size > 0) size--;
        }

        return (size+1)/2;
    }

}