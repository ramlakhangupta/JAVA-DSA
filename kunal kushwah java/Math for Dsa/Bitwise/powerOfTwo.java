public class powerOfTwo {
    public static void main(String[] args) {
        int n = 8; // here n = 0 case is exception 
        
        
         if((int)(n & (n-1)) == 0){
            System.out.println("Yes");
         } else 
         System.out.println("No");
    }
}
