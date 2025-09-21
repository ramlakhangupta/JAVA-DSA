class Solution {

    public boolean isCheck(String s, int i, int j) {
        if(i > j) {
            return true;
        }

        if(s.charAt(i) == s.charAt(j)) {
            return isCheck(s, i+1, j-1);
        }

        return false;
    }

    public int countSubstrings(String s) {
        int n = s.length();

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n ; j++) {
                if(isCheck(s, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
