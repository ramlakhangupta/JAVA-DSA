
public class sumOfDigitStringAfterConvert {
    
    public static int getLucky(String s, int k) {
        StringBuilder str = new StringBuilder();
        
        // Convert the string to a number by converting each character
        for (char c : s.toCharArray()) {
            int num = c - 'a' + 1;
            str.append(num);
        }
        
        // Convert the string to an integer sum
        int sum = 0;
        for (char c : str.toString().toCharArray()) {
            sum += c - '0';
        }
        
        // Perform the transformation k times
        for (int i = 1; i < k; i++) {
            int newSum = 0;
            while (sum > 0) {
                newSum += sum % 10;
                sum /= 10;
            }
            sum = newSum;
        }
        
        return sum;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        int k = 2;
        getLucky(s,k);
    }

}
