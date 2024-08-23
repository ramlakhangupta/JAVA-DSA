import java.util.*;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        // String name =  "Rahul";
        // Integer a = 4235678;
        // int code = a.hashCode();
        // System.out.println(code);

        HashMap<String, Integer> map = new HashMap<>();

        map.put("kunal", 89);
        map.put("karan", 99);
        map.put("rahul", 94);

        System.out.println(map.get("karan"));
        System.out.println(map.getOrDefault("Apporv", 78));

    }
}