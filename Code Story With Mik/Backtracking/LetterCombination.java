class Solution {
    List<String> result;

    public void solve(String digits, HashMap<Character, String> map, int idx, StringBuilder curr) {
        if (idx >= digits.length()) {
            result.add(curr.toString() );
            return;
        } 

        String str = map.get(digits.charAt(idx));

        for (int i = 0; i < str.length(); i++) {
            curr.append(str.charAt(i));
            solve(digits, map, idx + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder curr = new StringBuilder();

        solve(digits, map, 0, curr);

        return result;
    }
}
