public class streamWithOneArgument {
    public static void main(String[] args) {
        System.out.println(skip("baccdah"));
    }

     // SAME QUE SOLVE WITH PASS ONLY ONE ARGUMENT
     static String skip(String up){
        if(up.isEmpty()){
            return "";
        }

        char ch = up.charAt(0);
        

        //here substring function is used for creating a new sub string and to remove a first element 
        if(ch == 'a'){
            return skip(up.substring(1));
        } else {
            return ch + skip(up.substring(1));
        }
    }
}
