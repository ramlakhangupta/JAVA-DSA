public class Noto1 {

     public static void main(String[] args) {
        fun(5);
        funRev(5);
     }

    private static void fun(int n) {
       if(n == 0){
        return ;
       }

       System.out.println(n);
       fun(n-1);
    }

    private static void funRev(int n) {
        if(n==0){
            return;

        }

        funRev(n-1);
        System.out.println(n);
    }

    //CONCEPT   
    static void concept(int n){
        if(n == 0 ){
            return;
        }
        System.out.println(n);
        //  concept(n--); its basically pass n first after pass minus 
        concept(--n); // its bascially first minus after that pass 
        // n-- VS --n 
    }
}