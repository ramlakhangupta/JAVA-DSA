class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int maxFreq = freq[ch - 'a'];
            int j = i;
            while (j < maxFreq) {
                char setCharacter = s.charAt(j);
                maxFreq = Math.max(maxFreq, freq[setCharacter - 'a']);
                j++;
            }
            int totalLen = j - i + 1;
            i = j;
            result.add(totalLen);
        }
        return result;
    }
}
