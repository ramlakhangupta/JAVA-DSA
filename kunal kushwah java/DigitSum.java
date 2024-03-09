public class DigitSum {

    public static void main(String[] args) {
        int ans = sum(1342);
        System.out.println(ans);
    }

    private static int sum(int i) {
      if(i == 0){
        return 0;
      }

      return (i%10)+sum(i/10); 
      
    }
}