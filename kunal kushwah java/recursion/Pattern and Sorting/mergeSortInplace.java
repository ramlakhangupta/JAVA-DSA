import java.util.Arrays;

public class mergeSortInplace {
    public static void main(String[] args) {
        int arr[] ={5,4,3,2,1};
        merge(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    //this function works to divide the array gradually 
    static void merge(int[] arr, int s, int e){
        if(e-s == 1){
            return;
        } 

        int mid = (s+e)/2;

        merge(arr, s, mid);
        merge(arr, mid, e);

        mergeInPlace(arr, s,mid, e);;
    }

    //this function works to merge the array gradually
    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e-s];
        
        int i = s;
        int j = m;
        int k = 0;

        while(i < m && j < e){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            } else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        //it may be possible that one of the array is not complete
        //copy the remaining element
        while (i < m){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < m){
            mix[k] = arr[j];
            j++;
            k++;
        }

        for(int l =0; l < mix.length;l++){
            arr[s+l] = mix[l];
        }
    }
}
