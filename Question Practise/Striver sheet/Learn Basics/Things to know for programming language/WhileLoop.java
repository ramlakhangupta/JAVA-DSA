public class WhileLoop {
    static void printTable (int n) 
	 {
            int multiplier=10;
            while(multiplier>0)
            {
                int ans = multiplier*n;
                System.out.print(ans+ " ");
                multiplier-- ;
            }
       System.out.println();
	 }
}
