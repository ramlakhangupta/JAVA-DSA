import java.util.List;
import java.util.ArrayList;

public class TwoS {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    // Write your code here
    int i=0;
    int j = 0;
    int val = 0;
    int count = 0;
        while(maxSum > 0) {
            if(a.get(i) >= b.get(j) ) {
                val = a.get(i);
               
                i++;
            } else {
                val = b.get(j);
                
                j++;
            }
            count++;
            maxSum = maxSum-val;
        }
        return count;

    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(4);
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(1);
        List<Integer> b = new ArrayList<Integer>();
        a.add(2);
        a.add(1);
        a.add(8);
        a.add(5);
        System.out.println(twoStacks(10, a, b));
    }

}
