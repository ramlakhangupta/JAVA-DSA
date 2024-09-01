public class Convert1Dto2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int ans[][] = new int[m][n];
        int count = 0;
        if(m*n == original.length){
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    ans[i][j] = original[count];
                    count += 1;
                }
            }
            return ans;
        }
        return new int [0][0];
    }
    
}