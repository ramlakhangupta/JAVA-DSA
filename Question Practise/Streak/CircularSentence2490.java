public class CircularSentence2490 {
    

    public static boolean isCircularSentence(String sentence) {
        
        String[] words = sentence.split(" ");
        int n = words.length;
        if(n == 1){
            //check
            if(words[0].charAt(0) == words[0].charAt(words[0].length()-1)){
                return true;
            } else {
                return false;
            }
        }

        char firstChar = words[0].charAt(0);
        

        for(int i=0; i<n-1 ;i++){
            String word = words[i];
            int m = word.length();

            if(i < n-1 && word.charAt(m-1) == words[i+1].charAt(0)){
                continue;
            } else {
                return false;
            }
        }
        if(firstChar == words[n-1].charAt(words[n-1].length() - 1)) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(isCircularSentence(s));
    }
}
