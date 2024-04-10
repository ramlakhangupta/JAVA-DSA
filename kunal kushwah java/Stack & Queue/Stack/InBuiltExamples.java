import java.util.Stack;

//Stack implementation is internally in the class
//LIFO 
//FILO
public class InBuiltExamples {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("L");
        stack.push("A");
        stack.push("G");
        stack.push("N");
        stack.push("A");
        stack.push("M");
       
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
        System.out.print(stack.pop());
    }
}