class Solution {
    int n;

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public void solve(String s, int idx, List<String> curr, List<List<String>> result) {

        if (idx == n) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                solve(s, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }

    }

    public List<List<String>> partition(String s) {
        n = s.length();

        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        solve(s, 0, curr, result);

        return result;
    }
}
