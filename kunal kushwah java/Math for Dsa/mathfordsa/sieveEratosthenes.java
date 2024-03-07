public class sieveEratosthenes {
    public static void main(String[] args) {
        int n = 40;
        
        //create a boolean array for store the value
        boolean[] primes = new boolean[n+1];
        sieve(n,primes);
    }

    //IN QUESTION TRUE IS NOT PRIME AND FALSE IS PRIME !
    private static void sieve(int n, boolean[] primes) {

        for(int i=2;i*i<=n;i++){

            if(primes[i] == false){

                //ye loop unke factor ko htane ke liye use kar rhe h 
                for(int j=i*2;j<=n;j+=i){
                    primes[j] = true;
                }
            }
        }

        //ye loop jo no false h mtlb jo prime factor h unko hi print karwayega 
        for(int i=2;i<=n;i++){
            if(primes[i] == false){
                System.out.println(i + " ");
            }
        }
    }
}

//TIME COMPLEXITY = 0(log(logn))
  