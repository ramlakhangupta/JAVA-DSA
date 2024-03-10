public class Nto1 {
    public static void main(String[] args) {
        fun(1);
    }

    private static void fun(int n) {
      if(n >= 5){
        System.out.println(n);
        return ;
      }

      System.out.println(n);
      fun(n+1);
    }
}
