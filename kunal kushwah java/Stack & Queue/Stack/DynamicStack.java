public class DynamicStack extends cutsomStack{
    
    public DynamicStack(){
        super(); //it will call customstack();
    }

    public DynamicStack(int size){
        super(size); // it will call customstack(int size)
    }

    @Override
    public boolean push(int item) {
        //this take care of its begin full
        if (this.isfull()) {
           //double the array size;
           int[] temp = new int[data.length*2];

           //copy all previous item in new data
           for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
           }

           data = temp;
        }
        
        //at this point we know that array is not full
        //insert item 
        return super.push(item);
    }
}
