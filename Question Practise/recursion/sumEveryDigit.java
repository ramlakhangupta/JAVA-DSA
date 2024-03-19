public class sumEveryDigit {
    public static void main(String[] args) {
        int n = 45632;
        sum(n,0);
    }

    static void sum(int n, int sum){
        if(n<=0){
            System.out.println(sum);
            return;
        }
        sum = sum + n%10;
        sum(n/10,sum);
    }
}
