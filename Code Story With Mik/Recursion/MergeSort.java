public class MergeSort {
    void mergeSort(int arr[], int l, int r) {
        // code here
        
        if(l >= r ) {
            return ;
        }
        
        int m = l+(r-l)/2;
        
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        
        merge(arr, l, m, r);
    }
    
    
    void merge(int[] arr, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        int k = l;
         
        //fill left array
        for(int i=0; i<n1; i++) {
            left[i] = arr[k];
            k++;
        }
        //fill right array
        for(int i=0; i<n2; i++) {
            right[i] = arr[k];
            k++;
        }
        
        int i=0;
        int j=0;
        k = l;
        
        
        while(i<n1 && j < n2) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        
        while(i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        
        
    } 
}
