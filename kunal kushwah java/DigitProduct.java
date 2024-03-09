public class DigitProduct {
    public static void main(String[] args) {
        int ans = prod(1342);
        System.out.println(ans);
    }
   

    private static int prod(int i) {
        if(i%10 == i ){
          return i;
        }
  
        return (i%10)*prod(i/10); 
        
      }
}


