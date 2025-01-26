public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        return check(n,0);
    }

    public boolean check(int n, int i) {
        if(Math.pow(2, i) == n) {
            return true;
        } else if(Math.pow(2,i) > n) {
            return false;
        }

        return check(n, i+1);
    }
}
