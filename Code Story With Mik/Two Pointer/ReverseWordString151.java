class Solution {
    public String reverseWords(String s) {
        ArrayList<String> word = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            StringBuilder str = new StringBuilder();
            while(i < s.length() && s.charAt(i) != ' ') {
                str.append(s.charAt(i));
                i++;
            }
            if(str.length() > 0){
                word.add(str.toString());
            }
            i++;
        }

        int n = word.size();
        StringBuilder result = new StringBuilder();
        for(i = n-1; i >= 0; i--) {
            result.append(word.get(i));
            if(i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
