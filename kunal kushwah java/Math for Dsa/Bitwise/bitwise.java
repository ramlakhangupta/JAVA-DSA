

public class bitwise {
    public static void main(String[] args) {
        int bit = 1111111;
        int n = 5;
        System.out.println(isOdd(bit,n));
    }

    //No is even or odd using the concept of binary no
    public static boolean isOdd(int bit, int n) {
        return (1<<(n-1)) == 1;
    }

    // find single  no in array using x-or gate
    public static int ans(int[] arr){
        int unique = 0;

        // Apply x-or gate 
        for(int n : arr){
            unique ^= n; // here (^=)  this is sign is x-or gate 
        }

        return unique;
    }


    
}
