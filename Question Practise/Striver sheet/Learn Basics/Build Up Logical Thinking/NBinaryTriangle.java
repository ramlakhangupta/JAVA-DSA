public class NBinaryTriangle {
    public static void nBinaryTriangle(int n) {
        // Write your code here.
        for (int i = 0; i < n; i++) {
            int count = i;
            for (int j = 0; j < i+1; j++) {
                if (count%2 == 0) {
                    System.out.print("1 ");
                }else {
                    System.out.print("0 ");
                }
                count++;
            }
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nBinaryTriangle(5);
    }
}
