public class NstarTriangle {

    //        *
    //       ***
    //      *****
    //     *******
    
    public static void nStarTriangle(int n) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            for(int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //  *******
    //   *****
    //    ***
    //     *
    public static void nStarTriangleRverse(int n) {
        // Write your code here
        for(int i=0; i<n; i++){
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*(n-i)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void nStartriangle(int n) {
        // Write your code here
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }   
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i+1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        nStartriangle(4);
    }
}
