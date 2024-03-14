public class upperCase {
    public static void main(String[] args) {
        find("geek");
       
    }

    private static void find(String up) {
       if(up.isEmpty()){
        System.out.println("-1");
        return ;
       }
       char ch = up.charAt(0);

       if(ch<'Z'){
        System.out.println(ch);
       } else{
         find(up.substring(1));
       }
    }
}
