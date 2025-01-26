public class FindKthCharacterInStringGame3304 {
    public char kthCharacter(int k) {
        if ( k == 1) {
            return 'a';
        }

        return findChar(k, "a");
    }

    public char findChar(int k, String str){
        if(str.length() > k) {
            return str.charAt(k-1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length() ; i++){
            sb.append(str.charAt(i));
            sb.append((char)(str.charAt(i)+1));
        }
        
        return findChar(k, sb.toString());

    }
}
