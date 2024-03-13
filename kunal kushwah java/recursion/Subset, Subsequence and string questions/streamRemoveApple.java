public class streamRemoveApple {
    public static void main(String[] args) {
        System.out.println(skip("bacapplecdah"));
    }

    static String skip(String up){
        if(up.isEmpty()){
            return "";
        }
        
        //here substring function is used for creating a new sub string and to remove the element 
        if(up.startsWith("apple")){
            return skip(up.substring(5));
        } else {
            return up.charAt(0) + skip(up.substring(1));
        }
    }
}