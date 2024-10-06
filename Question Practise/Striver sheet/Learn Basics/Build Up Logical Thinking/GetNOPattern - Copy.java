public class GetNOPattern {
    public static void getNumberPattern(int n) {
        // Write your code here.
        for (int i = 0; i < n; i++) {
            int count = n;
            if (i == 0) {
                for (int j = 0; j < 2*n-1; j++) {
                    System.out.print(count);
                }
            } else {
                for (int j = 0; j < i; j++) {
                    System.out.print(count);
                    count--;
                }
                for (int j = 0; j < ((2*n-1)-2*i); j++) {
                    System.out.print(count);
                }
                count++;
                for (int j = 0; j < i; j++) {
                    System.out.print(count++);
                }
            }
            System.out.println();
        }

        for (int i = n-2; i >= 0; i--) {
            int count = n;
            
            for (int j = 0; j < i; j++) {
                System.out.print(count--);
            }
            for (int j = 0; j < 2*(n-i)-1; j++) {
                System.out.print(count);
            }
            count++;

            for (int j = 0; j < i; j++) {
                System.out.print(count++);
            }

            
            System.out.println();
        }
    }

    public static void main(String[] args) {
        getNumberPattern(5);
    }
}
