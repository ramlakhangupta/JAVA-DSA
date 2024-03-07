public class Pascals {
    public static void main(String[] args) {
        //Here n means no of rows in pascal triangle
        int n = 6; 

        //here basically in the pascal triangle theory its mention that sum of all row = 2ki power n 
        // and find nth row of sum i.e. 2 power (n-1)
        int ans = 1*(int)(Math.pow(2,n-1));
        System.out.println(ans);

    }
}
