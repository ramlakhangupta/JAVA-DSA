public class PalindromeNo9 {
   
        public boolean isPalindrome(int x) {
            int copy = x;
            int i = 10;
            long res = 0;
            while (x != 0) {
                int temp = (x % 10) * i;
                res = (res + temp) * 10;
                x = x / i;
            }
            res = res / 100;
            if (res >= 0 && res == copy) {
                return true;
            }
            return false;
        }
}
