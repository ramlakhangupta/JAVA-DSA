public class CountNo {
    public static void main(String[] args) {
        System.out.println(count(30210));
    }

    static int count(int n){
        return helper(n, 0);
    }

    //special pattern, how to pass a value to above call
    static int helper(int n,int c){
        //base condition
        if(n == 0){
            return c;
        }

        int rem = n%10;
        if(rem == 0){
            
            
            return helper(n/10,c+1);
        } else{
            return helper(n/10,c);
        }

    }
}
