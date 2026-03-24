/////////////////////////////////////////////        BRUTE FORCE      //////////////////////////
public int findPeakElement(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (max < nums[i]) {
                max = nums[i];
                ans = i;
            }
        }
        return ans;
    }
//////////////////////////////////////////////      OPTIMIZED        //////////////////////////////////////////
public int findPeakElement(int[] nums) {
        int n = nums.length;
        int i = 0; 
        int j = n-1;
        int max = Integer.MIN_VALUE;
        int ans = 0;

        while(i <= j) {
            if(nums[i] > nums[j]) {
                if(max < nums[i]) {
                    max = nums[i];
                    ans = i;
                } 
            } else {
                if(max < nums[j]) {
                    max = nums[j];
                    ans = j;
                } 
            }
            i++;
            j--;
        }
        return ans;
    }
