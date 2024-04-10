package Queue;

public class queueMain {
    public static void main(String[] args) throws Exception {
        DynamicQueue queue = new DynamicQueue(5);
        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);
        queue.insert(144);
        queue.insert(14);
        queue.insert(17);


        queue.display();
        System.out.println(queue.remove());
        queue.display();
    }
}
