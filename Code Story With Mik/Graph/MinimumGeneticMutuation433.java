class Solution {
    public int minMutation(String s, String e, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank)); // ye apan bank me baar check karne ke liye bna rhe h ki string bank me available h ki nhi 
        HashSet<String> visited = new HashSet<>(); // ye apan visited ke liye bna rhe h 
        Queue<String> que = new LinkedList<>(); // BFS 

        que.add(s);

        visited.add(s);
        int level = 0;

        while (!que.isEmpty()) {
            int n = que.size();
            while (n > 0) {
                String str = que.poll();

                if (str.equals(e)) { // lo ye apan ne bich me check karlenge ki apni string end ke equals to nhi ho gyi h...
                    return level;
                }

                for (char ch : new char[] { 'A', 'C', 'G', 'T' }) { // ACGT ke through puri string pe traverse marna h 
                    for (int i = 0; i < str.length(); i++) {
                        char[] chars = str.toCharArray();
                        chars[i] = ch;
                        String neighbor = new String(chars);

                        if (!visited.contains(neighbor) && bankSet.contains(neighbor)) {
                            que.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                n--;
            }
            level++;
        }

        return -1;
    }
}
