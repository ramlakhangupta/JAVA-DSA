public class houseRobberII213 {
        public static int rob(int[] nums) {
            int n=nums.length;
            if(n==1)
                return nums[0];
            int[] t1=new int[n-1];
            int[] t2=new int[n-1];
            
    
            int a=0,b=0;
            for(int i=0;i<n;i++){
                if(i!=0){
                    t1[a]=nums[i];
                    a++;
                }
                if(i!= nums.length-1){
                    t2[b] =nums[i];
                    b++;
                }
            }
            
            //max of array withput first and arr without last
            return Math.max(solve(t1),solve(t2));
        }
      
        
        static int solve(int[] arr){
            int n = arr.length;
            int prev = arr[0];
            int prev2 =0;
    
            for(int i=1; i<n; i++){
                int pick = arr[i];
                if(i>1)
                    pick += prev2;
                int nonPick = 0 + prev;
    
                int cur_i = Math.max(pick, nonPick);
                prev2 = prev;
                prev= cur_i;
    
            }
            return prev;
        }
        public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        System.out.println(rob(nums)); // Output: 4
    }

    
}
