public class StringCompressioniii3163 {
    
    public String compressedString(String word) {
        int count = 1;
        char prevCh = word.charAt(0);
        int n = word.length();
        StringBuilder str = new StringBuilder();

        for(int i=1 ; i<n ; i++){
            if(prevCh == word.charAt(i) && count < 9){
                count++;
            } else {
                str.append(count);
                str.append(prevCh);
                count = 1;
                prevCh = word.charAt(i);
            }

            
        }
                str.append(count);
                str.append(prevCh);
        return str.toString();
    }



    //Approach (Simple Simulation)
    //T.C : O(n)
    //S.C : O(1)
    public String compressedString1(String word) {
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        int i = 0;

        while (i < n) {
            int count = 0;
            char ch = word.charAt(i);

            while (i < n && count < 9 && word.charAt(i) == ch) {
                count++;
                i++;
            }

            comp.append(count).append(ch);
        }

        return comp.toString();
    }
}

