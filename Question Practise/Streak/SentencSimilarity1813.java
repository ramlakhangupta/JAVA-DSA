public class SentencSimilarity1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split both sentences into words
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        
        // Find common prefix
        int i = 0;
        while (i < Math.min(s1.length, s2.length) && s1[i].equals(s2[i])) {
            i++;
        }
        
        // Find common suffix
        int j = 0;
        while (j < Math.min(s1.length, s2.length) && s1[s1.length - 1 - j].equals(s2[s2.length - 1 - j])) {
            j++;
        }
        
        // Check if the remaining middle part of the shorter sentence is empty
        return i + j >= Math.min(s1.length, s2.length);
    }
}
