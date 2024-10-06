
public class DataTypes {
    public  static int dataTypeSize(String str) {
        if(str.equals("Integer") ||str.equals("Float")){
            return 4;
        } else if(str.equals("Character")){
            return 1;
        } else if(str.equals("Long") || str.equals("Double")){
            return 8;
        } 
        else{
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(dataTypeSize("Float")); // prints 4
    }

    
}
