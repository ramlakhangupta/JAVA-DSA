import java.util.*;

public class fruitIntoBasket904 {

    public int totalFruit(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0, j = 0,  n = arr.length, maxlen = 0;
        while (j<n) {
            if (map.containsKey(arr[j])) map.put(arr[j], map.get(arr[j]) + 1);
            else map.put(arr[j], 1);

            while (map.size() > 2) {
                int freq = map.get(arr[i]);
                if (freq == 1)  map.remove(arr[i]);
                else map.put(arr[i], freq - 1);
                i++;
            }

            int len  = j-i+1;
            maxlen = Math.max(maxlen,len);
            j++;
        }
        return maxlen;
    }


}
