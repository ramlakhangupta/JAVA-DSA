import java.util.HashMap;

public class nicePairs {

            //*  */ BRUTE FORCE APPROACH \* * \\

    // public int countNicePairs(int[] nums) {
    //     int counts = 0;
       
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         for (int j = i+1; j < nums.length; j++) {
    //             if (nums[i]+reverse(nums[j]) == reverse(nums[i])+ nums[j]) {
    //                 counts++;
    //             }
    //         }
    //     }
    //     return counts;
    // }

    // private int reverse(int i) {
    //   int reversed = 0;
    //   while (i!=0) {
    //     reversed = reversed * 10 + i % 10;
    //     i = i / 10;
    //   }
    //   return reversed;
    // }

    public int countNicePairs(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int def = nums[i] - reverse(nums[i]);
            if (!map.containsKey(def)) {
                map.put(def, 1);
            } else{
                
                int frequency = map.get(def);
               
                count += frequency;
                count %= 1000000007;
                map.put(def, frequency + 1 );
            }
        }
        return count;
    }

    private int reverse(int i) {
       int r = 0;

       while (i != 0) {
        r = r*10 + i%10;
        i /= 10;
       }
       return r;
    }
}
