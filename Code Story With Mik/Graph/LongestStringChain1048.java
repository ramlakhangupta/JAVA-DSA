class Solution {

    public boolean isPredecessor(String a, String b) {
        int j = 0;
        if (a.length() - b.length() == 1) {
            for (int i = 0; i < a.length(); i++) {

                if (j < b.length() && a.charAt(i) == b.charAt(j)) {
                    j++;
                }
            }
        } else {
            return false;
        }

        if (j == b.length()) {
            return true;
        }
        return false;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;

        int[] t = new int[n];
        Arrays.fill(t, 1);

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[i], words[j])) {
                    max = Math.max(t[j], max);
                }
            }
            t[i] += max;
        }

        return Arrays.stream(t).max().getAsInt();
    }
}
