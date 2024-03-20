public class primeOrNot {
    public static void main(String[] args) {
        System.out.println(prime(1,2));
    }

    private static boolean prime(int n,int i) {
        if(n == 2){
            return false;
        }

        if(n == 1){
            return true;
        }

        if(n == 0){
            return false;
        }
       if(i==n){
        return true;
       }

    if(n%i != 0){
        return prime(n,i+1);
    }
    return false;
}
    
}
