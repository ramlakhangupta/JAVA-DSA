class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int start = 0;
        int end = n - 1;
        while (start <= end) {

            if (start == end) {
                return 1;
            }
            
            if (s.charAt(start) == s.charAt(end)) {
                while (start < end && s.charAt(start) == s.charAt(end)) {
                    start++;
                }
                start--;
                while (start < end && s.charAt(end) == s.charAt(start)) {
                    end--;
                }
                end++;

                start++;
                end--;

                
            } else {
                return end - start + 1;
            }
        }
        return 0;
    }
}
