import java.util.*;
public class minimumTimeDiff539 {
    public int findMinDifference(List<String> t) {
        ArrayList<Integer> arr = new ArrayList<Integer>(t.size());

       for (int i = 0; i < t.size(); i++) {
            String str = t.get(i);
            arr.add(i, (((str.charAt(0) - 48) * 10 + str.charAt(1) - 48) * 60) +
            (str.charAt(3) - 48) * 10 + str.charAt(4) - 48);
       }
       Collections.sort(arr);
       int help;
       int temp = Integer.MAX_VALUE;

       help = arr.get(0) + 1440;

       for (int i = 1; i < arr.size(); i++) {
           if (arr.get(i) > help / 2) {
               temp = Math.min(temp, help - arr.get(i));
           }
           temp = Math.min(temp, arr.get(i) - arr.get(i - 1));
       }
       return temp;
   }
    
}