import java.util.HashMap;
public class makeSumDivisibleByP1590 {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int i:nums){
            sum = (sum+i)%p;
        }
        int target = sum%p;
        if(target == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int comSum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            comSum = (comSum + nums[i])%p;
            int checkSum = (comSum - target + p)%p; // isme hamne p ko isiliye add kiya taki modulo negative me na jaye      }
            if(map.containsKey(checkSum)){
                int j = map.get(checkSum);
                int length = i-j;
                minLen = Math.min(minLen, length);
            } 
            map.put(comSum, i);
        }
        if(minLen >= nums.length){
            return -1;
        }
        return minLen;
    }
}
