public class NumberCrown {
    public static void numberCrown(int n) {
        // Write your code here.
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < i+1; j++) {
                System.out.print(count+ " ");
                if (count != i+1) {
                    count++;
                }
            }
            for (int j = 0; j < 2*(n-i)-2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i+1; j++) {
                System.out.print(count-- +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        numberCrown(5);
    }
}
