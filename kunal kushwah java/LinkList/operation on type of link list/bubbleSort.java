import org.w3c.dom.Node;



public class bubbleSort {


    private Node head;
    private Node tail;
    private int size;

    public bubbleSort() {
        this.size = 0;
        
    }

   public void bubblesSort(){
    bubblesSort(size-1, 0);
   }
}

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

private void bubblesSort(int row, int col){
    if(row == 0){
        return;
    }
    if(col < row){
        Node first = get(col);
        Node second = get(col+1);

        if(first.value > second.value){
            //swap
            if (first.value > second.value) {
                head = second;
                first.next = second.next;
                second.next = first;
            } else if (second == tail) {
                Node prev = get(col-1);
                prev.next = second;
                tail = first;
                first.next = null;
                second.next = tail;
            } else {
                Node prev = get(col-1);
                prev.next = second;
                first.next = second.next;
                second.next = first;

            }
        }
        bubblesSort(row, col+1);
    } else {
        bubblesSort(row-1, 0);
    }
}
