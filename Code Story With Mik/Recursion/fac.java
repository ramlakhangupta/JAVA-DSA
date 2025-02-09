public class fac {

        public static void main(String[] args) {
            int n = 5;
            System.out.println(printNto1(n,  1));
    
        }
    
        public static int printNto1(int n,  int fac) {
            if(n <= 0) {
                return fac;
            }
    
            
            return printNto1(n-1,  fac*n);
        }

    
}
