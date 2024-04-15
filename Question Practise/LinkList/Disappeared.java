import java.util.ArrayList;
import java.util.List;

public class Disappeared {

    public void cycleSort(int nums[]){
        int n = nums.length;
        int index = 0;
        while (index < n) {
            int element = nums[index];
            int correctPos = element-1;
            if(nums[index] != nums[correctPos]){
                swap(nums,index,correctPos);
            } else {
                index++;
            }
        }
    }

    public void swap(int[] nums, int index, int correctPos) {
        int temp = nums[index];
        nums[index] = nums[correctPos];
        nums[correctPos] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        cycleSort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                list.add(i+1);
            }
        }
        return list;
    }
}