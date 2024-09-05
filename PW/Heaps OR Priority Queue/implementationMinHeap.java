class MinHeap{

    private int[] arr;
    private int size;


    //CONSTRUCTOR
    MinHeap(int capacity){
        arr = new int[capacity];
        size = 0;
    }


    //ADD FUNCTION of Min-HEAP
    public void add(int num)  throws Exception{
        if (size == arr.length) {
            throw new Exception("Heapis FUll !");
        }
        arr[size++] = num;

        upheapify(size-1);

    }


    //UP-HEAPIFY FUNCTION : CHCECK THE PARENT IS SMALLER OR NOT TO CHILD. AND CHECK ALL THE ARRAY.
    public void upheapify(int index ){
        //base case
        if (index == 0) {
            return ;
        }

        int parent = (index- 1)/2;
        if (arr[index] < arr[parent] ) {
            swap(index, parent);
            upheapify(parent);
        }
    }


    //SWAP FUNCTION
    public void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //PEEK FUNCTION : RETURN THE MINIMUM(AS PER HEAP) ELEMENT IN THE HEAP
    public int peek() throws Exception{
        if (size == 0){
            throw new Exception("Heap is empty");
        } 
        return arr[0];
    }


    //SIZE OF ITEM IN TOTAL CAPACITY
    public int size() {
        return size;
    }

    //DOWN HEAPIFY FOR REMOVE THE ITEM
    public void downHeapify(int i) {

        if (i >= size-1) {
            return ;
        }
        int lc = 2*i + 1, rc = 2*i + 2; // left child & right child
        int minIdx = i;
        if (lc < size && arr[lc] < arr[minIdx]) {
            minIdx = lc;
        }
        if (rc < size && arr[rc] < arr[minIdx]) {
            minIdx = rc;
        }
        if (i == minIdx) {
            return ;
        }
        swap(i, minIdx);
        downHeapify(minIdx);
    }


    //REMOVE FUNCTION FOR REMOVING THE ELEMENT
    public int remove() throws Exception{
        if (size == 0)  {
            throw new Exception("Heap is empty!");
        }

        int peek = arr[0];
        swap(0, size - 1);
        size--;
        downHeapify(0);
        return peek;
    }

}

public class implementationMinHeap {
    public static void main(String[] args) throws Exception {
        MinHeap pq = new MinHeap(10);
        pq.add(1);
        pq.add(3);
        pq.add(8);
        pq.add(0);
        
        System.out.println("Peek element: " + pq.peek());
        System.out.println("Size of heap: " + pq.size());

        pq.remove();
        System.out.println(pq.peek());
    }


}