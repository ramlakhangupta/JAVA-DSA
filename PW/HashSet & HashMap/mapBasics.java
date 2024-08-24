import java.util.HashMap;

public class mapBasics {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Raghav", 76);
        map.put("Himanshu", 780);
        map.put("Amrit", 75);
        map.put("Ansusa", 66);
        System.out.println(map+ " " +map.size());
        map.put("RL", 89);
        System.out.println(map+ " " +map.size());
        map.put("Raghav", 20);
        System.out.println(map+ " " +map.size()+ " "+map.containsValue(66) );
        map.remove("raghav");
        System.out.println(map+ " " +map.size());
        System.out.println(map.get("Himanshu"));
        
    }
}
