public class RotateString796 {
    


    //Approach-1 (Brute Force Check all rotations)
    //T.C : O(n^2)
    //S.C : O(1)
    public static boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();

        // If the lengths are not equal, they can't be rotations
        if (m != n) {
            return false;
        }

        // Check all possible rotations
        for (int rotationCount = 1; rotationCount <= m; ++rotationCount) {
            // Perform one rotation by shifting left by one character
            s = s.substring(1) + s.charAt(0);
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }



    //Approach-2 (Concatenation with itself contains all possible rotations)
    //T.C : O(n)
    //S.C : O(1)
    public static boolean rotateString1(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        
        // Check if the lengths match and if goal is a substring of s + s
        if (m == n && (s + s).contains(goal)) {
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s, goal)); // true
    }

}
