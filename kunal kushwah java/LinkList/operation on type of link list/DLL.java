public class DLL {
    private Node head;
    

    // INSERTION AT FIRST IN DOUBLY LINKLIST
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
         }
         head = node;
    }
    

    // INSERTION AT LAST IN DOUBLY LINKLIST
    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    // FIND THE VALUE 
    public Node get(int value){
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // INSERTION AT ANY LOCATION IN DOUBLY LINKLIST
    public void insert(int after , int val){
        Node p = get(after);
        
        if(p == null){
            System.out.println("does not exist");
            return ;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    //DISPLAY FUNCTION
    public void display(){
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    
    
    private class Node {
    int val;
    Node next;
    Node prev;

    public Node (int val){
        this.val = val;
    }

    public Node(int val, Node next, Node prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
        
    }
}
