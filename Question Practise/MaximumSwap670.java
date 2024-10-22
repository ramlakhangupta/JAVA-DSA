public class MaximumSwap670 {
    public static int maximumSwap1(int num) {
        // Convert the number to a string for easier manipulation of digits
        char[] s = Integer.toString(num).toCharArray();
        
        // Create an array to store the last occurrence of each digit
        int[] last = new int[10];  // There are only 10 possible digits (0-9)
        
        // Fill the array with the last occurrence of each digit
        for (int i = 0; i < s.length; i++) {
            last[s[i] - '0'] = i;
        }
        
        // Traverse the number and try to find a digit to swap
        for (int i = 0; i < s.length; i++) {
            // Try to find a larger digit in the rest of the string to swap with
            for (int d = 9; d > s[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap the digits
                    char temp = s[i];
                    s[i] = s[last[d]];
                    s[last[d]] = temp;
                    
                    // Return the result after the swap
                    return Integer.parseInt(new String(s));
                }
            }
        }
        
        // If no swap was made, return the original number
        return num;
    }


    public static int maximumSwap(int num) {
        String s = Integer.toString(num); // Convert num to string
        int n = s.length();

        int[] maxRight = new int[10]; // To store the last occurrence of each digit
        for (int i = 0; i < 10; i++) {
            maxRight[i] = -1;
        }

        // Fill the maxRight array with the last occurrence index of each digit
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - '0'; // Convert char to integer
            maxRight[idx] = i;
        }

        // Find the first place to swap to get the largest number
        for (int i = 0; i < n; i++) {
            int currDigit = s.charAt(i) - '0';

            // Try to find a larger digit to swap with current one
            for (int digit = 9; digit > currDigit; digit--) {
                if (maxRight[digit] > i) {
                    // Swap the current digit with the larger one found
                    char[] charArray = s.toCharArray();
                    char temp = charArray[i];
                    charArray[i] = charArray[maxRight[digit]];
                    charArray[maxRight[digit]] = temp;

                    // Return the modified number
                    return Integer.parseInt(new String(charArray));
                }
            }
        }

        return num; // If no swap is made, return the original number
    }



    public static void main(String[] args) {
        System.out.println(maximumSwap(9973));
    }
}
