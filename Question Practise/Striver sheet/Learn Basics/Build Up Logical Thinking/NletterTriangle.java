public class NletterTriangle {
    public static void nLetterTriangle(int n) {
        
        // Write your code here
        for (int i = 0; i < n; i++) {
            char c = 65;
            for (int j = 0; j < i+1; j++) {
                System.out.print(c++ +" ");

            }

            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nLetterTriangle(5);
    }
}
