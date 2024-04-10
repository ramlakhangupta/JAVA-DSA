package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class InBuiltExamples {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(89);
        deque.add(78);
        deque.addFirst(23);
        System.out.println(deque);

    }
}
