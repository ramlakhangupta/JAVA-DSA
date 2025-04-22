class Solution {

    public char DFS(HashMap<Character, List<Character>> map, char ch, int[] visited) {
        visited[ch - 'a'] = 1;

        char minChar = ch;

        for (char v : map.getOrDefault(ch, new ArrayList<>())) {
            if (visited[v - 'a'] == 0) {
                minChar = (char) Math.min(minChar, DFS(map, v, visited));
            }
        }
        return minChar;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        HashMap<Character, List<Character>> map = new HashMap<>();
        int m = baseStr.length();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(s1.charAt(i), k -> new ArrayList<>()).add(s2.charAt(i));
            map.computeIfAbsent(s2.charAt(i), k -> new ArrayList<>()).add(s1.charAt(i));
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < m; i++) {
            char ch = baseStr.charAt(i);

            int[] visited = new int[26];
            char minChar = DFS(map, ch, visited);
            str.append(minChar + "");
        }

        return str.toString();
    }
}
