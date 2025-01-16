public class LeapOfFaith {

    public static void main(String[] args) {
        String s = "abc";
        rever(s);
    }

    private static void rever(String s) {
         solve(s, 0);
    }

    private static void solve(String s, int i) {
        if (i>= s.length()) {
            return;
        }
        solve(s, i+1);
        System.out.print(s.charAt(i));
        return;
    }

    public static int fac(int n ) {
        if(n <=  1) {
            return 1;

        }

        return n*fac(n-1);

        
    }



}
