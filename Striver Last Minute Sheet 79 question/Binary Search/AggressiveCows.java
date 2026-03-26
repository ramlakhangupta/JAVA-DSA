///////////////////////////////////////////////     OPTIMIZED         ////////////////////////////////////////////////////////////
public int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        Arrays.sort(stalls);
        int start = 1;
        int end = stalls[n-1] - stalls[0];
        int ans = 1;
        while(start <= end ) {
            int mid = start + ( end - start ) / 2;
            if(isPossible(stalls, mid, k)) {
                start = mid+1;
                ans = Math.max(ans, mid);
            } else {
                end = mid-1;
            }
        }
        
        return ans;
    }


    public boolean isPossible(int[] stalls, int mid, int k) {
        int n = stalls.length;
        int val = stalls[0];
        k -= 1;
        for(int i = 1; i < n; i++ ) {
            if(stalls[i] - val >= mid) {
                val = stalls[i];
                k--;
            }
        }
        
        if(k <= 0) {
            return true;
        }
        return false;
    }
