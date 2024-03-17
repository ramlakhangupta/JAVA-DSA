import java.util.ArrayList;

public class mazeDirectionDiagonally {
    
    public static void main(String[] args) {
        System.out.println(directionDiagoList("", 3, 3));
        directionDiagonal("", 3, 3);
    }


     //find direcion ,diagonally also by normal recursion
    static void directionDiagonal(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return ;
        }

        if(r>1){
            directionDiagonal(p + 'V',r-1, c);
        }

        //let if it goes to diagonally then it full fill both the condition 
        if(r>1 && c>1){
            directionDiagonal(p + 'D', r-1, c-1);
        }

        if(c>1){
            directionDiagonal(p + 'H', r, c-1);
        }
    }



    //find direction by Arraylist recursion
    static ArrayList<String> directionDiagoList(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(directionDiagoList(p+'V',r-1, c));
        }
        if(r>1 && c>1){
            list.addAll(directionDiagoList(p + 'D', r-1, c-1));
        }
        
        if(c>1){
            list.addAll(directionDiagoList(p+'H', r, c-1));
        }
        return list;
    }
}
