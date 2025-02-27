class Solution {
    List<String> result;
    HashSet<String> set;

    public void solve(int i, String currSentence, String s) {

        // base case
        if (i >= s.length()) {
            result.add(currSentence);
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String tempWord = s.substring(i, j + 1);
            if (set.contains(tempWord)) {
                String tempSentence = currSentence;

                if (!currSentence.isEmpty()) {
                    currSentence += " ";
                }
                currSentence += tempWord; // take

                solve(j + 1, currSentence, s); // explore

                currSentence = tempSentence; // remove

            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new LinkedList<>();
        set = new HashSet<>();

        for (String word : wordDict) {
            set.add(word);
        }

        String currSentence = "";
        solve(0, currSentence, s);
        return result;
    }
}
