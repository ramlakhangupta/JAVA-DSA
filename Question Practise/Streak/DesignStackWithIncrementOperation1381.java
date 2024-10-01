public class DesignStackWithIncrementOperation1381 {

    int[] arr;
    int index;
    public void CustomStack(int maxSize) {
        arr = new int[maxSize];
        index = 0;
    }
    
    public void push(int x) {
        if(arr.length == index){
            return;
        } else {
            arr[index] = x;
            index++;
        }
    }
    
    public int pop() {
        if(index == 0) {
            return -1;
        } else {
            index--;
            int s = arr[index];
            
            return s;
        }
    }
    
    public void increment(int k, int val) {
        for(int i=0; i<k ; i++){
            if(i < arr.length) {
                arr[i] += val;
            }
        }
    }
}