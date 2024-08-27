import java.util.HashMap;
import java.util.ArrayList;


public class threeDigitEven {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //Fill HashMap withgiven number
        for (int i = 0; i < digits.length; i++) { 
            if (!map.containsKey(digits[i])) {
                map.put(digits[i], 1);
            } else {
                int frequency = map.get(digits[i]);
                map.put(digits[i], frequency+1);
            }
        }

        //Find 3-digit numbers that contain even digits and add them to the ArrayList ans.
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for(int i = 100; i < 999; i+= 2) { // check only for even digits so iterate with jump of two
            int x = i ;
            int c = x%10;
            x = x/10;       // by this we have to figure out the number of digits particularly
            int b = x%10;
            x = x/10;
            int a = x;

           
            //CORE CONCEPT:
            //ch   eck the a contains or not...
            if (map.containsKey(a)) {
                int aFreq = map.get(a); //by this we have to figure out the frequency is availabe or not in the map if yes then check for b but before, 
                map.put(a, aFreq-1);    // we need to saw the frequency of key 
                    if (aFreq == 1 ) {  // let for 222 we have to print only one, so we remove if the frequency is 1.
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


        int[] ans2 = new int[ans.size()];
        for(int i = 0; i < ans2.length; i++) {
            ans2[i] = ans.get(i);
        }
        return ans2;

    }
}
