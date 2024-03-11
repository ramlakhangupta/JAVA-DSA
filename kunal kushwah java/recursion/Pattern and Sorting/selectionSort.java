import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int arr[] = {4,3,2,8,1};
        selection(arr,0,arr.length,0);
        System.out.println(Arrays.toString(arr));
    }

    private static void selection(int[] arr, int max, int row, int col) {
        //base condition
       if(row == 0){
        return;
       }

       if(row > col){

        if(arr[col] > arr[max]){

            selection(arr, col, row, col+1);
          
        } else{
            selection(arr, max, row, col+1);
        } 
       } else{
        //swap
        int temp = arr[max];
        arr[max] = arr[row-1];
        arr[row-1] = temp;
        selection(arr, 0, row-1, 0);
       }
    }
}
