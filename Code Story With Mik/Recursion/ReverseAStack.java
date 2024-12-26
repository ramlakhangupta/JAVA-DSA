import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(7);
        stack.push(6);
        reverseStack(stack);
    }

   // public static void reverseStack(Stack<Integer> stack)  {
    //     if (stack.size() == 0) {
    //         return ;
    //     }

    //     int ele = stack.peek();
    //     stack.pop();
    //     reverseStack(stack);
    //     Stack<Integer> temp = new Stack<>();
    //     while (!stack.isEmpty()) {
    //         temp.push(stack.peek());
    //         stack.pop();
    //     }
    //     stack.push(ele);
    //     while (!temp.isEmpty()) {
    //         stack.push(temp.peek());
    //         temp.pop();
    //     }
    //     System.out.println(stack);
    // }  
    
    public static void insertAtBottom(Stack<Integer> stack, int element){
        if (stack.isEmpty()) {
            stack.push(element);
            return ;
        }

        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return ;
        }

        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
        
    }

}
