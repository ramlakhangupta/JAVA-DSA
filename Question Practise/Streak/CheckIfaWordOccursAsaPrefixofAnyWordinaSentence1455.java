public class CheckIfaWordOccursAsaPrefixofAnyWordinaSentence1455 {
    
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int count = 0;
        int len = 0;

        
        for (String word : words) {
            if (word.charAt(0) == searchWord.charAt(0)) {
                len = 0;
                for (int i = 0; i < searchWord.length(); i++) {
                    if (i < word.length() && word.charAt(i) == searchWord.charAt(i)) {
                        len++;
                    }

                    if (len == searchWord.length()) {
                        return count + 1;
                    }
                }
            }
            count++;

        }

        return -1;
    }

    public static void main(String[] args) {
        String arr = "hello from the other side";
        String swa = "they";
        System.out.println(isPrefixOfWord(arr, swa));
    }
}
