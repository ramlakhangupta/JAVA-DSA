public class permutation {
    public static void main(String[] args) {
        permutate("", "abc");
    }

    static void permutate(String p, String up){

        // Base Condition
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for(int i=0;i<=p.length();i++){
            String f = p.substring(0, i);

            String s = p.substring(i,p.length());
            permutate(f+ch+s, up.substring(1));
        }
    }
}
