import java.util.HashSet;

public class countNumber {
    // problem no 2442

    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            
            set.add(reverse(nums[i]));
        }
        return set.size();
    }

    private int reverse(int nums) {
        int r = 0;
        while (nums != 0) {
            r = r * 10 + nums % 10;
            nums /= 10;
        }
        return r;
    }
}
