public class AddingSpacesToString2109 {

    public static String addSpaces(String s, int[] spaces) {
        int n = spaces.length;
        StringBuilder str = new StringBuilder();
        int j = 0;
        for(int i=0; i<n; i++){
            str.append(s.substring(j, spaces[i])+" ");
            j = spaces[i];
        }
        str.append(s.substring(j));
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        System.out.println(addSpaces(s, spaces));
        
    }
}


