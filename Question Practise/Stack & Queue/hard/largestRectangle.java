package Hard;

public class largestRectangle {
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        System.out.println(rectangle(arr));
     }

     public static int rectangle(int[] arr){
        int maxRec = 0 ;

        for (int i = 0; i < arr.length; i++) {
            int value =  arr[i];
            int ans = check(arr,arr[i],i);
            if(ans > maxRec){
                maxRec = ans;
            } 
        }
         
        return maxRec;

     }

     public static int check(int arr[], int value, int index){
        
        int ans = 0;
        //left check 
        for (int i = index ; i >= 0; i--) {
            if(value <= arr[i]){
               
                ans += value;
            } else {
                
                break;
            }
        
        }

         //right check
        for (int i = index ; i <= arr.length; i++) {
            if (value == arr[i]) {
                
            }
            if(value < arr[i]){
                
                ans += value;
            } else {
               
                break;
            }
            
        
        }
        return ans;
     }
}

