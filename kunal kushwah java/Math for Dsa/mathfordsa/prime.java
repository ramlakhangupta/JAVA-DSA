public class prime {
    public static void main(String[] args) {
        int n = 40;
        for(int i=0; i<=n;i++){
            System.out.println(i + " " +isPrime(i));
        }
    }

    static boolean isPrime(int n ){
        //here we find all negative and less or equal to 1 nos
        if(n<=1){
            return false;
        }

        //now we checked already to till 1 no we want check by 2 or more
        int c = 2; 

        //in the while loop we reduce the t(n) only we checked once time not the repeating time
        while(c*c <= n){
            if(n%c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
    
}