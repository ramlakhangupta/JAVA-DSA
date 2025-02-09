public class Sum {
        public static void main(String[] args) {
            int n = 2;
            System.out.println(printNto1(n, 0, 1));
    
        }
    
        public static int printNto1(int n,int i,  int sum) {
            if(n < i) {
                return sum;
            }
    
            
            return printNto1(n, i+1, sum+i);
        }
    }
    

