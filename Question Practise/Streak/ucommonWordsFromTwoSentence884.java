import java.util.*;

public class ucommonWordsFromTwoSentence884 {

    
    public static String[] uncommonFromSentences(String s1, String s2) {
        HashSet<String> set = new HashSet<String>();
        HashSet<String> dupSet = new HashSet<String>();

        String[] words1 = s1.split(" ");
        
        String[] words2 = s2.split(" ");

        for (String word : words1) {
            if (!dupSet.contains(word)) {
                if (set.contains(word)) {
                    set.remove(word);
                    dupSet.add(word);
                } else {
                    set.add(word);
                }

            }
        }

        for (String word : words2) {
            if (!dupSet.contains(word)) {
                if (set.contains(word)) {
                    set.remove(word);
                    dupSet.add(word);
                } else {
                    set.add(word);
                }
            }
        }
        ArrayList<String> list = new ArrayList<>(set);

        String[] array = list.toArray(new String[0]);

        return array;
    }

    public static List<String> uncommonFromSentences1(String s1, String s2) {
        HashSet<String> set = new HashSet<String>();
        HashSet<String> dupSet = new HashSet<String>();

        String[] words1 = s1.split(" ");
        
        String[] words2 = s2.split(" ");

        for (String word : words1) {
            if (!dupSet.contains(word)) {
                if (set.contains(word)) {
                    set.remove(word);
                    dupSet.add(word);
                } else {
                    set.add(word);
                }

            }
        }

        for (String word : words2) {
            if (!dupSet.contains(word)) {
                if (set.contains(word)) {
                    set.remove(word);
                    dupSet.add(word);
                } else {
                    set.add(word);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(uncommonFromSentences(s1, s2));
    }
}