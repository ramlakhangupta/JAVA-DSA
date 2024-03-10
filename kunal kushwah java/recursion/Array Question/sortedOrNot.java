public class sortedOrNot{
    public static void main(String[] args) {
        int arr[] = {10,15,11,118};
        System.out.println(helper(arr,0));
    }

    

    private static boolean helper(int[] arr, int i) {
       if(i == arr.length-1){
        return true;
       }

       
        return (arr[i] < arr[i+1] && helper(arr, i+1));
     
    }

    
}