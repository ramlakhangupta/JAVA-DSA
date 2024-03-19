import java.util.Arrays;

public class recInsertion {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        insert(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

    static void insert(int[] arr,int j){
        int i = j;
        //base condition
        if(j == arr.length){
            return;
        }
        while (i>0 && arr[i]<arr[i-1]) {
            //swap
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
            i--;
        }
        insert(arr, j+1);
        
    }
}
