public class XorQueriesOfaSubarray1310 {

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        


        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i][0];
            int temp2 = queries[i][1];
            while(temp != temp2+1){
                ans[i] ^= arr[temp];
                temp++;
            }
        }
        return ans;
    }


    public static void main (String[] args) {
        int[] arr = {16};
        int[][] queries = {{0,0},{0,0},{0,0}};
        xorQueries(arr, queries);
    }
}