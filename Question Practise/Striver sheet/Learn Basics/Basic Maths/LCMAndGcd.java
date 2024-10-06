public class LCMAndGcd {
    static Long[] lcmAndGcd(Long a , Long b) {
        // code here
        int i = 2;
        int gc = 1;
        while(a!=1 || b!=1) {
            if (a%i == 0 && b%i == 0) {
                a = a/i;
                b = b/i;
                gc = gc*i;
                i--;
                
            } 
            i++;

        }
        Long[] l = new Long[2];
       
        return l;
    }

    public static void main(String[] args) {
        Long a = (long)10;
        Long b = (long)5;
        Long[] ans = lcmAndGcd(a, b);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
