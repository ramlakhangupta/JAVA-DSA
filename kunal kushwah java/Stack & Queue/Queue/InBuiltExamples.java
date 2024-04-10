package Queue;

import java.util.LinkedList;
import java.util.Queue;


//Queue Implementation is internally as a INTERFACE
//FIFO
//LILO


public class InBuiltExamples {
   public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(6);
        queue.add(5);
        queue.add(19);
        queue.add(1);

    System.out.print(queue.peek());  
    System.out.println(queue);
    System.out.println(queue.remove(19));
    System.out.println(queue);
   }    
    
}
