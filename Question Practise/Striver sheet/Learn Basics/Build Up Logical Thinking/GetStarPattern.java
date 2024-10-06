public class GetStarPattern {
    public static void getStarPattern(int n) {
        // Write your code here
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n-1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int j = 0; j < n; j++) {
                    if (j == 0 || j == n - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        getStarPattern(10);
    }
}
