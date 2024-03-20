public class productTwoNo {
    public static void main(String[] args) {
        System.out.println(product(100, 5));

    }

    private static int product(int x, int y) {
        
        if( x<y){
            
            return product(y,x);
        }

        else if(y!=0){
            return (x+product(x, y-1));
        } else{
            return 0;
        }
        
    }

    
}
