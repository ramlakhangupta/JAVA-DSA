public class MinimumAddParentheses921 {

    public int minAddToMakeValid(String s) {
        int size = 0;
        int size1 = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' ) {
                size++;
            } else if(size > 0) {
                size--;
            } else  {
                size1++;
            }
            
        }
        return size1+size;
    }
}