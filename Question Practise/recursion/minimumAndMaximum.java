public class minimumAndMaximum {

    public static void main(String[] args) {
        int arr[] = {1,4,3,-5,-4,8,6};
        
        minimum(arr,0,1);
        maximum(arr,0,1);
    }

    private static int minimum(int[] arr, int min, int i) {
        //base condition
        if(arr.length == i){
            System.out.println(arr[min]);
            return 0;
            
        }

        if(arr[min]<arr[i]){
            return minimum(arr, min, i+1);
        } else{
            return minimum(arr, i, i+1);
        }

    }

    private static int maximum(int[] arr, int max, int i) {
        //base condition
        if(arr.length == i){
            System.out.println(arr[max]);
            return 0;
            
        }

        if(arr[max]<arr[i]){
            return maximum(arr, i, i+1);
        } else{
            return maximum(arr, max, i+1);
        }

    }
}