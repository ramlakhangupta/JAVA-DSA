import java.util.HashSet;

public class MaxNoIntegerToChooseFromRangei2554 {
    
    public int maxCount1(int[] banned, int n, int maxSum) {
        int len = banned.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<len; i++){
            set.add(banned[i]);
        }

        int count = 0;
        int sum = 0; 
        int j = 1;
        while(j <= n){

            //check is available
            if(set.contains(j)){
                j++;
                continue;
            }
            //sum is greater or not 
            sum += j;
            if(sum > maxSum) {
                sum -= j;
                j++;
                continue;
            }
            //count increment 
            count++;
            j++;
        }
        return count;
    }

    //Approach - Simple Greedily select smallest numbers
    //T.C : O(n)
    //S.C : O(m)
    public static int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : banned) {
            set.add(num);
        }

        int count = 0;
        int sum = 0;

        for (int num = 1; num <= n; num++) {
            if (set.contains(num)) {
                continue;
            }

            if (sum + num <= maxSum) {
                count++;
                sum += num;
            } else {
                break;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] banned = {11};
        int n = 7;
        int maxSum = 50;

        System.out.println(maxCount(banned, n, maxSum));
    }
}
