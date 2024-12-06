public class DeleteCharactersMakeFancyString1957 {
    

    public static String makeFancyString(String s) {
        int n = s.length();
        int count = 1;
        char prevChar = s.charAt(0);
        StringBuilder ans = new StringBuilder();


        for(int i=1; i<n; i++){
            if(count < 3){
                ans.append(prevChar);
            }
            if(s.charAt(i) == prevChar){
                count++;
                
            } else {
                prevChar = s.charAt(i);
                count = 1;
            }
        }

        if(count < 3){
            ans.append(prevChar);
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        String s = "aaabaaaa";
        System.out.println(makeFancyString(s));
    }
}
