import java.util.ArrayList;

public class factor {
    public static void main(String[] args) {
        factors3(20);
    }


    


    // TIME COMPLEXITY = 0(n)
    private static void factors1(int n) {
        for(int i = 1; i<=n ; i++){

            if(n%i == 0){
                System.out.println(i + " ");
            }
        }
    }


    //TIME COMPLEXITY = 0(sqrt(n))
    // ISSUE - in this code issue is the output is not arrange sequencely
    private static void factors2(int n) {
        for(int i = 1;i<=Math.sqrt(n);i++){
 
         if(n%i == 0){

             if(n/i == 0){
                 System.out.println(i + " ");
             } else {
                 System.out.println(i + " " + n/i + " ");
             }
         }
        }
     }


     //TO SOLVE THIS ISSUE WE USE ARRAYLIST - :
     private static void factors3(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1;i<=Math.sqrt(n);i++){
 
         if(n%i == 0){

             if(n/i == 0){
                 System.out.println(i + " ");
            } else {
                 System.out.println(i + " ");
                 list.add(n/i);
                }
            }
        }

        for(int i = list.size() - 1 ;i>=0;i--){
            System.out.println(list.get(i) + " ");
        }
     }
}
