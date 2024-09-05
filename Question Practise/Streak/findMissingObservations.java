public class findMissingObservations {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;
        
        int[] ans = new int[n];
        int ans1 = mean*(len + n);
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
           sum += rolls[i];
        }
        int ans2 = ans1 - sum;
        if (ans2 < n || ans2 > 6*n) {
            return new int[0];
        }

        int baseValue = ans2 / n;
        int remainderValue = ans2 % n;
        for (int i = 0; i < n; i++) {
        
           ans[i] = baseValue;
        }
        for (int i = 0; i < remainderValue; i++) {
            ans[i] += 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {6,3,4,3,5,3};
        int mean = 1;
        int n = 6;
        System.out.println(missingRolls(arr,mean,n));
    }
}
