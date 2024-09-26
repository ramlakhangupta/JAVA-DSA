import java.util.HashMap;

public class SumPrefixScoreOfString2416 {


    //self TLE
    public static int[] sumPrefixScores1(String[] words) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String str = "";
            for (int l = 0; l < words[i].length(); l++) {
                str += words[i].charAt(l);
                if (!map.containsKey(str)) {
                    map.put(str, 1);
                } else {
                    int freq = map.get(str);
                    map.put(str, freq + 1);
                }
            }
        }
        
        
        int[] res = new int[words.length];
        String str = "";
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                str += words[i].charAt(j);
                count += map.get(str);
            }
            res[i] = count;
            str = "";
        }
        return res;
    }



    //TREE YT
    class Solution {
        public static int[] sumPrefixScores(String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
    
            int[] res = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                res[i] = trie.getPrefixScore(words[i]);
            }
            return res;
        }
    }
    
    




    public static void main(String[] args) {
        String[] words = {"abc","ab","bc","b"};
        sumPrefixScores1(words);
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    int count = 0;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.count++;
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.count++;
    }

    public int getPrefixScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            score += node.count;
        }
        return score;
    }
}

