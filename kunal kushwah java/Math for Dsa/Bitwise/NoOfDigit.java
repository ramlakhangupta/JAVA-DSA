public class NoOfDigit{
    public static void main(String[] args) {
        int n = 34567;
        int b = 10;

        //formula for find no of digit  formula = (int)(Math.logbn)+1 ; here b refers the base
        //this formula is used for that purpose is to solve base problem base (b)
        int ans = (int)(Math.log(n) / Math.log(b)) + 1;

        System.out.println(ans);
    }
}