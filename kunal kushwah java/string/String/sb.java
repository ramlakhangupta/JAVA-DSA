import java.util.*;
public class sb {

    public static int letter() {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<26; i++){
            char ch = (char)('a' +i);
            builder.append(ch);
        }
        System.out.println(builder.toString());
        return 0;
    }

    public static int methods(){
        String name = "kunal kushwaha";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());
        System.out.println(name);
        System.out.println(name.indexOf('a'));
         System.out.println("    kunal   ".strip());
  
         return 0;
    }

    //here we use repalce method to solve this 
    public static String defangIpAdress(String address) {
        return address.replace("." , "[.]");       
    }

    //SHUFFLE THE STRING AS PER THE ARR    
    public static String shuffleString(String prr, int arr[]) {
            // now create a new arr to store the right value 
            char result[] = new char[arr.length];
            for(int i=0; i<arr.length;i++){
                result[arr[i]] = prr.charAt(i);
            }
           return new String(result);
        }


    public static String goalParserInterpretation(String command) {
        
        String ans = command.replace("()" , "o"); 
        
        return ans.replace("(al)" , "al");
    }

    public static 



    public static void main(String args[]){
        String command = "(al)G(al)()()G";
        System.out.println(goalParserInterpretation(command)); 
    }
}