public class corporateFlightBookings {


    // 748 sec for execute
    public int[] corpFlightBookings(int[][] arr, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int last = arr[i][1];
            int seat = arr[i][2];
            for (int j = first - 1; j < last ; j++) {
                ans[j] += seat;
            }
        }
        return ans;
    }

    public static int[] corpFlightBookings1(int[][] arr, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int last = arr[i][1];
            int seat = arr[i][2];
            ans[first-1] += seat;
            if(last == n){
                continue;
            }
            ans[last] -= seat;
        }

        
        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1,2,10},
            {2,3,20},
            {2,5,25}
        };
        int k = 5;
        corpFlightBookings1(arr, k);
    }

}
