import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int arr[] ={5,4,3,2,1};
        arr = merge(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] merge(int[] arr){
        if(arr.length == 1){
            return arr;
        } 

        int mid = arr.length/2;

        int[] left = merge(Arrays.copyOfRange(arr, 0, mid));//here copyOfRange function state that in array from 0 to mid give range to left name array
        int[] right = merge(Arrays.copyOfRange(arr, mid, arr.length));//here copyOfRange function state that in array from mid to arr.length give range to right name array

        return mergeSor(left,right);
    }

    private static int[] mergeSor(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length){

            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            } 
            
            else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        
        //it may be possible that one of the array is not complete
        //copy the remaining element
        while (i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
    
}
