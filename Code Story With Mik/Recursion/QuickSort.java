public class QuickSort {

    static void quickSort(int arr[], int low, int high) {
        // code here
        if(low >= high) {
            return ;
        }
        
        int pivot = partition(arr, low, high);
        
        quickSort(arr, low, pivot-1);
        quickSort(arr, pivot+1, high);
        
    }

    static int partition(int arr[], int low, int high) {
        // your code here
        int pivot = arr[high];
        int Pi = low;
        
        for(int i=low; i<high; i++) {
            if(arr[i] <= pivot) {
                swap(arr, i, Pi);
                Pi++;
            }
        }
        swap(arr, Pi, high);
        return Pi;
    }
    
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
}