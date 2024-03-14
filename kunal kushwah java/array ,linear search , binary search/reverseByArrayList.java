import java.util.Collections;
import java.util.ArrayList;

public class reverseByArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(8);
        l.add(10);
        l.add(4);
        l.add(15);
        l.add(78);
        l.add(12);
        l.add(36);
        System.out.println("Original list :"+l);
        Collections.reverse(l);
        System.out.println("Reversed list :"+l);

    }

    // private static void reverse(ArrayList<Integer> l) {
       
    //     int i = 0;
    //     int j = l.size()-1;
    //     while(i<j){

    //         //isme hamesa variable declare wrapper class ke form me hi hoga
    //         Integer temp = Integer.valueOf(l.get(i));
    //         l.set(i, l.get(j));
    //         l.set(j, temp);
    //         i++;
    //         j--;
    //     }
    //     System.out.println(l);
    // }   
}
