import java.util.Arrays;
public class firstjava{


 public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            if(i+1 != nums[i]){
                return nums[i];
            }

        }
        return -1;

    }


    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));
        
    }
}