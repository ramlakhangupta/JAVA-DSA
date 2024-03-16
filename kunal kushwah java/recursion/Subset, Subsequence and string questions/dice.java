import java.util.ArrayList;

public class dice {
    public static void main(String[] args) {
        diceFace("", 4, 6);
        diceFind("", 4);
        System.out.println(diceList("", 4));
        System.out.println(diceListFace("", 4, 6));
    }

    //solve by normal recursion
    static void diceFind(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            diceFind(p+i, target-i);
        }
    }


    static void diceFace(String p, int target,int face){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            diceFace(p+i, target-i,face);
        }
    }




    //solve by Arraylist
    static ArrayList<String> diceList(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceList(p+i, target-i));
        }
        return list;
    }


    static ArrayList<String> diceListFace(String p, int target, int face){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            list.addAll(diceListFace(p+i, target-i,face));
        }
        return list;
    }
}
