import java.util.*;
public class minimumTimeDiff539 {
    public static int findMinDifference(List<String> list) {
        boolean mins[] = new boolean[1440];
        for(String time : list){
            int h = Integer.parseInt(time.substring(0,2));
            int m = Integer.parseInt(time.substring(3,5));
            int minutes = h*60 + m;
            if(mins[minutes]) return 0;
            mins[minutes] = true;
        }

        int prev = -1;
        int firstVal = -1;
        int minDiff = Integer.MAX_VALUE;
        for(int cur = 0; cur < 1440; cur++ ){
            if(mins[cur]) {
                if(prev == -1) {
                    firstVal = cur;
                    prev = cur;
                } else {
                    minDiff = Math.min(minDiff, cur-prev);
                    prev = cur;
                }
            }
        }

        if(prev != -1){
            minDiff = Math.min(minDiff, 1440+ firstVal- prev);
        }
        return minDiff;
    }    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
      
            list.add(0,"23:59");
            list.add(1,"00:00");

        System.out.println(findMinDifference(list));
        
    }
}
