import java.util.ArrayList;

public class streamWithAscii {
    public static void main(String[] args) {
        System.out.println(subseq("","abc"));
    }

    static void subSet(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        } 

        char ch = up.charAt(0);

        subSet(p + ch, up.substring(1));
        subSet(p+(ch+0), up.substring(1));
        subSet(p, up.substring(1));
    }


    //BY ARRAYLIST
    static ArrayList<String> subseq(String p, String up){
        ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()){
            
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> first = subseq(p+ch, up.substring(1));
        ArrayList<String> second = subseq(p+(ch+0), up.substring(1));
        ArrayList<String> third = subseq(p, up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
        //in the above function first.addAll refers the first arraylist ,it store the all element of second list and also third list, After it then return the first 
        //it means here it all depend to above you if you want to store in first then first.addAll(any element), and second then second.addAll(anyelement)
        //and after return the list to the main function 
    }
}
