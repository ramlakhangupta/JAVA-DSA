import java.util.ArrayList;

public class rotateArrayIn {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int n = A.size();
        B = B % n;  // In case B is greater than the size of the array
    
        for (int i = 0; i < n; i++) {
            ret.add(A.get((i + B) % n));
        }
    
        return ret;
    }

    public static void main(String[] args) {
        int count = 1;
        ArrayList<Integer> A = new ArrayList<Integer>(6);
        for (int i = 0; i < 6; i++) {
            A.add(count);
            count += 1;
        }
        int B = 1;
        rotateArray(A,B);
    }
    
}


