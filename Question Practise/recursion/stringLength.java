
public class stringLength {
    public static void main(String[] args) {
      System.out.println(len("GEEKSFORGEEKS",0));
    }

    private static  int len(String up, int count) {
       if(up.isEmpty()){
        return count;
       }

       
       return len(up.substring(1),count+1);
    }
}
