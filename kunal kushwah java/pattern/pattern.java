import java.util.*;

public class pattern{
    public static void main(String args[]){

        p17(5);
    }
    
    public static int p1(int n){
        for(int row=1; row<=n;row++){
            for(int col = 1; col <= row; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
        return 0;
    }

    public static int p2(int n){
        for(int row=1; row<=n;row++){
            for(int col = 1; col <= n; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
        return 0;
    }

     public static int p3(int n){
        for(int row=1; row<=n;row++){
            for(int col = 1; col <= n-row+1; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
        return 0;
    }

     public static int p4(int n){
        for(int row=1; row<=n;row++){
            for(int col = 1; col <= row; col++){
                System.out.print(col);
            }
            System.out.println();
        }
        return 0;
    }

     public static int p5(int n){
        for(int row=0; row<=2*n;row++){
            int totalColInRow = row > n ? 2*n-row : row; 
            for(int col = 0; col <= totalColInRow; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
        return 0;
    }

    public static int p28(int n){
        for(int row=0; row<=2*n;row++){
            int totalColInRow = row > n ? 2*n-row : row; 
            int noOfSpaces = n-totalColInRow;
            for(int s = 0; s<noOfSpaces ; s++){
                System.out.print(" ");
            }
            for(int col = 0; col <= totalColInRow; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
        return 0;
    }

    public static int p30(int n){
        for(int row=1; row<=n;row++){
            for(int s = 0; s<n-row ; s++){
                System.out.print(" ");
            }
            
            for(int col = row; col >= 1; col--){
                System.out.print(col);
            }
            for(int col = 2; col <= row ; col++){
                System.out.print(col);
            }
            System.out.println();
        }
        return 0;
    }

    public static int p17(int n){
        for(int row=1; row<=2*n;row++){
            int c = row > n ? 2*n-row : row;
            for(int s = 0; s<n-c ; s++){
                System.out.print(" ");
            }
            
            for(int col = c; col >= 1; col--){
                System.out.print(col);
            }
            for(int col = 2; col <= c ; col++){
                System.out.print(col);
            }
            System.out.println();
        }
        return 0;
    }
}