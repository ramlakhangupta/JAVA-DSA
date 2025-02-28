class Solution {
    int result = 0;
    HashSet<String> set = new HashSet<>();

    public void solve(String s, int i, int count) {

        if (i >= s.length()) {
            result = Math.max(result, count);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String tempString = s.substring(i, j + 1);
            if (!set.contains(tempString)) {
                set.add(tempString);
                solve(s, j + 1, count + 1);
                set.remove(tempString);
            }
        }
    }

    public int maxUniqueSplit(String s) {

        solve(s, 0, 0);
        return result;
    }
}
