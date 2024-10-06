public class forloops {
    public static void main(String[] args) {
		int n = 8;
        
            int[] arr = new int[n+1];
            
            arr[1] = 1;
            arr[2] = 1;
            for(int i=3; i<=n; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
            System.out.println(arr[n]);
            
        }
    
}
