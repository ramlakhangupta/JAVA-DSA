import java.util.HashMap;


public class maxNumberKSum {

    public static int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int key = k - nums[i];
            if (map.containsKey(nums[i])) {
                count++;
                map.remove(key);
            } else {
                map.put(key,nums[i]);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,3,1,1,4,1};
        int k = 4;
        System.out.println(maxOperations(nums, k));
    }
    
}
