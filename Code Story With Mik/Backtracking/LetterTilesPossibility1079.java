class Solution {
    int total = 0;

    public void solve(String tiles, StringBuilder curr, HashSet<String> set, boolean[] used) {
        total++;

        set.add(curr.toString());

        for (int i = 0; i < tiles.length(); i++) {

            if (!used[i]) {
                used[i] = true;
                curr.append(tiles.charAt(i));

                solve(tiles, curr, set, used);

                curr.deleteCharAt(curr.length() - 1);
                used[i] = false;

            }
        }
    }

    public int numTilePossibilities(String tiles) {
        HashSet<String> set = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        StringBuilder curr = new StringBuilder();
        solve(tiles, curr, set, used);
        return set.size() - 1;
    }
}
