

public class minimumPenaltyForAShop2483 {

    //Creating 3 Array solution
    public static int bestClosingTime2(String customers) {
        int n = customers.length();
        int[] pre = new int[n+1];
        pre[0] = 0;
        int[] suf = new int[n+1];
        suf[n] = 0;
        int[] ans = new int[n+1];


        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1];
            if (customers.charAt(i-1) == 'N'){
                pre[i] += 1; 
            }   
            
        }
        for (int i = n-1; i >=0 ; i--) {
            suf[i] = suf[i+1];
            if (customers.charAt(i) == 'Y') {
                suf[i] += 1;
            }
        }
  
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans[i] = pre[i] + suf[i];
            min = Math.min(min,ans[i]);
        }

       for (int i = 0; i <= n; i++) {
            if (ans[i] == min) {
                return i;
            }
       }
        return -1;

    }

    //Creating 2 array solution
    public static int bestClosingTime1(String customers) {
        int n = customers.length();
        int[] pre = new int[n+1];
        pre[0] = 0;
        int[] suf = new int[n+1];
        suf[n] = 0;
       

        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i-1];
            if (customers.charAt(i-1) == 'N'){
                pre[i] += 1; 
            }   
            
        }
        for (int i = n-1; i >=0 ; i--) {
            suf[i] = suf[i+1];
            if (customers.charAt(i) == 'Y') {
                suf[i] += 1;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            pre[i] = pre[i] + suf[i];
            min = Math.min(min,pre[i]);
        }

       for (int i = 0; i <= n; i++) {
            if (pre[i] == min) {
                return i;
            }
       }
        return -1;

    }


   

    public static void main(String[] args) {
        String str = "YNYY";
        System.out.println(bestClosingTime1(str));
    }
}
