
public class subSet {
    public static void main(String[] args) {
        subSet("","abc");
    }

    static void subSet(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        } 

        char ch = up.charAt(0);

        subSet(p + ch, up.substring(1));
        subSet(p, up.substring(1));

    }
    
}
