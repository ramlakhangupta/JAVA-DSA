public class steamAppnotApple {

    public static void main(String[] args) {
        System.out.println(skipAppNotApple("bacappcdah"));
        System.out.println(skipAppNotApple("bacapplecdah"));
    }

    static String skipAppNotApple(String up){
        if(up.isEmpty()){
            return "";
        }
        
        //here substring function is used for creating a new sub string and to remove the element 
        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipAppNotApple(up.substring(3));
        } else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        }
    }
}