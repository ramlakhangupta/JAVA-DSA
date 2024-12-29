public class PowerOfThree326 {
    public static boolean isPowerOfThree(int n) {
        if(n < 1 ) {
            return false;
        }
        if(n == 1) {
            return true;
        }

        return helper(n);
    }

    public static boolean helper(int n){
        if(n <= 3) {
            if(n%3 == 0){
                return true;
            } else {
                return false;
            }
        }

        return helper(n/3);
    }

    public static void main(String[] args) {
        int n = 19684;
        System.out.println(isPowerOfThree(n));
    }
}
