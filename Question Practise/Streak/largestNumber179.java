import java.util.*;

public class largestNumber179 {
    public String largestNumber(int[] arr) {
       int n = arr.length;
       String elements[] = new String[n];
       for (int i = 0; i < n; i++) {
            elements[i] = Integer.toString(arr[i]);
       }

       //knlogn
       Arrays.sort(elements, new Comparator<String>() {
            public int compare(String a, String b) {
                String first = a + b;
                String sec = b + a;
                return sec.compareTo(first); // k
            }
       });
       if (elements[0].equals("0")) {
        return "0";
       }
       StringBuilder str = new StringBuilder();
       for (String val : elements) {
            str.append(val);
       }
       return str.toString();

    }
}
