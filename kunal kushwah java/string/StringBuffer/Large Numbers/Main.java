import java.math.BigDecimal;
import java.math.BigInteger;

class Main {
    
    public static void main(String[] args) {
        BD();
    }

    static void BD() {
        double x = 0.03;
        double y = 0.04;

        // double ans = y-x;
        // System.out.println(ans);

        BigDecimal X = new BigDecimal(".03");
        BigDecimal Y = new BigDecimal(".04");
        BigDecimal ans = Y.subtract(X);
        //System.out.println(ans);

        BigDecimal a = new BigDecimal("4");
        BigDecimal b = new BigDecimal("5");

        //operations

        System.out.println(b.add(a));
        System.out.println(b.subtract(a));
        System.out.println(b.multiply(a));
        System.out.println(b.pow(2));
        System.out.println(b.negate());
      
        //constants
        BigDecimal con = BigDecimal.ONE;
        

    }


    static void BI() {
        int a = 30;
        int b = 67;

        BigInteger B = BigInteger.valueOf(6); // convery int / long to BI
        int c = B.intValue(); // convert BI to int 
        BigInteger C = new BigInteger("236574484646484");
        BigInteger X = new BigInteger("54946165141684");


        //constants 
        BigInteger D = BigInteger.TEN;

        //operations
        BigInteger s = C.add(X);

        BigInteger m = C.multiply(X);

        BigInteger sub = C.subtract(X);

        BigInteger d = C.divide(X);

        BigInteger rem  = C.remainder(X);
       
        if (X.compareTo(C) < 0 ) {
            System.out.println("YES");
        }

        System.out.println(Factorial.fact(100));



    }
}
