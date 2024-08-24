import java.util.HashSet;

public class MaxNoOfString {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<String>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String rev = reverse(words[i]);
            if (set.contains(rev)) {
                count++;
                set.remove(rev);
            }
            else set.add(words[i]);
        }
        return count;
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
