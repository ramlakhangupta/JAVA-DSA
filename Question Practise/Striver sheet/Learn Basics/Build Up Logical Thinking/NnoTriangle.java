public class NnoTriangle {
    public static void nNumberTriangle(int n) {
        // Write your code here
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(count++ +" ");
                
            }
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nNumberTriangle(5);
    }
}
