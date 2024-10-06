
public class ReverseInteger7 {
    public static int reverse(int x) {
        int i = 10;
        long res = 0;
        while (x != 0) {
            int temp = (x % 10) * i;
            res = (res + temp) * 10;
            x = x / i;
        }
        res = res / 100;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }


    public static int reverse1(int x) {
        long res = 0; // Use long to handle overflow cases
        while (x != 0) {
            int temp = x % 10; // Get the last digit
            res = res * 10 + temp; // Add the last digit to the result
            x = x / 10; // Remove the last digit from x
        }

        // Check if the result is within the range of int
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0; // Return 0 if overflow occurs
        }

        return (int) res; // Safely cast to int
    }


    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
