package Medium;

import java.util.Arrays;

import java.util.Scanner;

public class gamesOfTwoStack {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();// in this quesing indexing start from 0 then 1 means two stack
        // here , t = no of stack
        // n = no of elemnt in stack1
        // m = no of element in stack2
        // x = maxsum (limit) 
      for (int i = 0; i < t; i++) {
        int n = s.nextInt();
        int m = s.nextInt();
        int x = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int j = 0; j < n; j++) {
            a[j] = s.nextInt();
        }
        for (int j = 0; j < m; j++) {
            b[j] = s.nextInt();
        }
        System.out.println(twoStacks(x, a, b));
    }
    }

    

    public static int twoStacks(int x, int[] a, int[] b) {
        return helper(x,a,b,0,0) - 1;
    }



    private static int helper(int x, int[] a, int[] b, int sum, int count) {
       if(sum > x){
        return count;
       }

       if(a.length == 0 || b.length == 0){
        return count;
       }

       int ans1 = helper(x, Arrays.copyOfRange(a,1,a.length), b, sum + a[0], count+1);
       int ans2 = helper(x, a,Arrays.copyOfRange(b,1,b.length), sum + b[0], count+1);

       return Math.max(ans1, ans2);

    }

   
}
