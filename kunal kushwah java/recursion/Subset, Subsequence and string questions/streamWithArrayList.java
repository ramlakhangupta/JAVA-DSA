
import java.util.ArrayList;


public class streamWithArrayList {
    public static void main(String[] args) {
        System.out.println(subseq("", "abc"));
    }

    static ArrayList<String> subseq(String p, String up){
        ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subseq(p+ch, up.substring(1));
        ArrayList<String> right = subseq(p, up.substring(1));

        left.addAll(right);
        return left;

    }

    
}
