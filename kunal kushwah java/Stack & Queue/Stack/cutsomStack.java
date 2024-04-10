public class cutsomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;
    
    public cutsomStack(){
        this(DEFAULT_SIZE);
    }

   public cutsomStack(int size){
    this.data = new int[size];
   }

    public boolean push(int item){
        if(isfull()){
            System.out.println("Stack is Full!!");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot pop from an wmpty stack!!");
        }
        //int removed = data[ptr];
        //ptr--;
        //return removed;
        return data[ptr--];
    }
    
    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot peek from an wmpty stack!!");
        }
        return data[ptr];
    }

    public boolean isfull(){
        return ptr == data.length-1; // ptr is at last index

    }

    public boolean isEmpty(){
        return ptr == -1;
    }
}
