class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(n < k) {
            return -1;
        }
        int start = 0;
        long end = 0;
        for(int val : arr) {
            end += val;
        }
        int ans = Integer.MAX_VALUE;
        
        while(start <= end) {
            int mid = start + ((int)end - start ) / 2;
            if(isPossible(arr, mid, k)) {
                end = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                start = mid+1;
            }
        }
        return ans;
    }
    
    public boolean isPossible(int[] arr, int mid, int k) {
        int n = arr.length;
        int student = 1; 
        int pages = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i] > mid) {
                return false;
            }
            
            if(pages + arr[i] <= mid) {
                pages += arr[i];
            } else {
                student++;
                pages =arr[i];
            }
        }
        
        return (student > k) ? false : true;
    }
    
}
