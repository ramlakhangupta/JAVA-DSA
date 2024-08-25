import java.util.HashMap;
import java.util.ArrayList;


public class threeDigitEven {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < digits.length; i++) {
            if (!map.containsKey(digits[i])) {
                map.put(digits[i], 1);
            } else {
                int frequency = map.get(digits[i]);
                map.put(digits[i], frequency+1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();


        for(int i = 100; i < 999; i+= 2) {
            int x = i ;
            int c = x%10;
            x = x/10;
            int b = x%10;
            x = x/10;
            int a = x;

           

            if (map.containsKey(a)) {
                int aFreq = map.get(a);
                map.put(a, aFreq-1); 
                    if (aFreq == 1 ) {
                        map.remove(a);
                    }
                if (map.containsKey(b)) {
                    int bFreq = map.get(b);
                map.put(b, bFreq-1); 
                    if (bFreq == 1 ) {
                        map.remove(b);
                    }
                    if (map.containsKey(c)) {
                        ans.add(i);
                    }
                    map.put(b, bFreq);
                }
                map.put(a, aFreq);
            }
        }
    }
}
