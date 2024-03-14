import java.util.ArrayList;

public class arraylist {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
    //wrapper classess
    Integer in = Integer.valueOf(4);
    System.out.println(in);
    Float f = Float.valueOf((float) 4.5);
    System.out.println(f);


     ArrayList<Integer> l1 = new ArrayList<>();

    //add new element
    l1.add(5);
    l1.add(4);
    l1.add(2);
    l1.add(0);
    l1.add(7);
    l1.add(8);


    //get an element at index i
    System.out.println(l1.get(1)); // 4

    
    //print with the loops
    for(int i=0; i< l1.size();i++){
        System.out.println(l1.get(i)); //5,4,2,0,7,8
    }

    //printing the array list directly
       System.out.println(l1); //5,4,2,0,7,8


    //adding element at some index
    l1.add(1,100);
    System.out.println(l1); //[5,100,4,2,0,7,8]


    //modifying element at index i
    l1.set(1,10);
    System.out.println(l1); //[5,10,4,2,0,7,8]



    //removing an element ar index i
    l1.remove(1);
    System.out.println(l1); //[5,4,2,0,7,8]

    //removing an element e
    l1.remove(Integer.valueOf(7));
    System.out.println(l1);//[5,4,2,0,8]


    //checking if an element exists
    boolean ans = l1.contains(Integer.valueOf(8));
    System.out.println(ans);


    //if you don't specify class, you can put anything inside l
    
    ArrayList l = new ArrayList<>();
    l.add(1);
    l.add("sita");
    System.out.println(l);












    }
}
