public class fibonacci{
    public static void main(String args[]){
        for(int i = 0; i< 10;i++){
          System.out.println(fiboFormula(i));
        }

        
    }

    //FIBONACCI BY RECURSION
    public static int fibo(int n){
        //base condition
        if(n<2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }

    //PRINT 1 TO 5 USING RECURSION
    public static void print(int n){
        // base condition 
        if(n==5){
            System.out.println(n);
            return;
        } 
        System.out.println(n);

        //recursive call
        // if you are calling a function again and again, you can treat it as a separate call in the stack

        //this is called tail recursion
        // this is a function call
        print(n+1);
    }


    //SEARCH BINARY NO USING RECURSION
    public static int bin (int arr[], int target, int start, int end) {
      if(start > end){
        return -1;
      }

      int mid = start + (end - start)/2;
      
       if (target == arr[mid]) {
            return mid;
      } 

      if(target > arr[mid]){
        return bin(arr,target,mid+1,end);
      } 
      return bin(arr, target, start, mid-1);

    }

    //FIND NTH FIBONACCI NO USING THE GOLDEN RATIO  
    public static int fiboFormula(int n){
      //just for demo , use long instead
      return (int) ((Math.pow(((1+Math.sqrt(5))/2), n) - Math.pow(((1-Math.sqrt(5))/2), n)) / Math.sqrt(5));
    }
}