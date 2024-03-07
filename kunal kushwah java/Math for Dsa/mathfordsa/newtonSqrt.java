public class newtonSqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(40));
    }

    public static double sqrt(double n){
        double x = n;
        double root ;

        while(true){
            root = 0.5*(x+(n/x)); // newton raphson method 

            if(Math.abs(root - x) < 0.5){ // abs means absolute to find always positive value
                break;
            }

            x= root;
        }

        return root;
    }
}
