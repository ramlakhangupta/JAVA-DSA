import java.util.ArrayList;

public class maze{
    public static void main(String[] args) {
        System.out.println(directionList("",3, 3));
    }

    static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int left = count(r-1, c);
        int right = count(r, c-1);
        return left + right;
    }




    static void direction(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return ;
        }

        if(r>1){
            direction(p+'D',r-1, c);
        }

        if(c>1){
            direction(p+'R', r, c-1);
        }
    }


    static ArrayList<String> directionList(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(directionList(p+'D',r-1, c));
        }

        if(c>1){
            list.addAll(directionList(p+'R', r, c-1));
        }
        return list;
    }
}