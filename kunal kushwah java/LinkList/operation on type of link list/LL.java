public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
        
    }


    //INSERT AT 1ST POSTITION
    public void insertFirst(int val){
        Node node = new Node(val); //create a  new node
        node.next = head; //now its confirm node next is head
        head = node; // now 1 st node is head

        if(tail == null){ // when list is empty it have 0 node
            tail = head;
        }
        
        size += 1;
    }


    //INSERT AT LAST POSTITION
    public void insertLast(int val){

        //check list is empty then call the insertFirst function and return .
        if(tail == null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val); //create a  new node
        tail.next = node; // connect to the tail
        tail = node; // now last node is tail
        size++;
    }

    //INSERT AT SPECIFIC LOCATION
    public void insert(int val, int index){
        if(tail == null){
            insertFirst(val);
            return;
        }

        if(index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        } 

        Node node = new Node(val,temp.next);
        temp.next = node;

        size++;
    }

    //INSERT USING RECURSION
    public void insertByRec(int val, int index){
        head = insertByRec(val, index, head);
    }

    private Node insertByRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertByRec(val, index-1, node.next);
        return node;
    }

    //DELETION AT FIRST POSTITION 
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null ){
            tail = null;

        }
        size--;
        return val;
    }


    // FIND THE VALUE 
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    //DELETION AT LAST POSTITION
    public int deleteLast(){
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get( size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    // DELETION AT SPECIFIC LOCATION
    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        return val;
    }

    //FIND A NODE
    public Node find(int value){
        Node node = head;
        while (node != null) {
            if(node.value == value){
                return node;  
              }
              node = node.next;
        }
        return null;
    }

    public void display(){
        Node temp = head; //here we create a temp variable and allocate the head 
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //declaration of node , value and next
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }


    //QUESTIONS

    // 1. TO remove a duplicate node by the list
    public void duplicates() {
        Node node = head;

        while (node.next != null) {
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            } else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // 2. Merge Two Sorted Linked Lists
    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }

    
}

