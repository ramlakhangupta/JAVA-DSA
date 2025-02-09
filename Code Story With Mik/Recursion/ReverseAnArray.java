public class ReverseAnArray {
        public static void main(String[] args) {
            int[] arr = {10, 12, 14, 15, 1, 5};
            reverseArray(arr, 0);

            for(int val : arr) {
                System.out.print(val);
                System.out.print("  ");
            }
    
        }
    
        public static void reverseArray(int arr[], int i) {
            if(i == arr.length/2) {
                return ;
            }
    
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;

            reverseArray(arr, i+1);
        }
    
    
}
