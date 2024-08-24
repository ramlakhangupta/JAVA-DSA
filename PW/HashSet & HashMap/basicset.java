import java.util.HashSet;

public class basicset {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        //insert : TC = O(1)
        set.add(20);
        set.add(100);
        System.out.println("size is : " + set.size());
        set.add(10);
        // Search - true/ false : TC = O(1)
        System.out.println(set.contains(50)); 
        set.add(50);
        System.out.println(set.contains(50));
        System.out.println("size is : " + set.size());
        //remove : TC = O(1)
        set.remove(100);
        System.out.println("size is : " + set.size());
        set.remove(15); // remove karne par ignore kar dega if exists nhi h 
        System.out.println(set.size());

        Object[] arr = set.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}