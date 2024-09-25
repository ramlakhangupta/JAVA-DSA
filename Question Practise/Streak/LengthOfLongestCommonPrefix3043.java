import java.util.*;
public class LengthOfLongestCommonPrefix3043 {

    //self solve
    public  static int longestCommonPrefix1(int[] arr1, int[] arr2) {
        String[] a = new String[arr1.length];
        String[] b = new String[arr2.length];
        
        for (int i = 0; i < arr1.length; i++) {
            a[i] = Integer.toString(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            b[i] = Integer.toString(arr2[i]);
        }

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int l=0;
        int k = 0;
        int j = 0;
        
            while(l < b[j].length() && (a[i].charAt(k) != b[j].charAt(l)) ) {
                l++;
                
            } 
            if (l < b[j].length() && a[i].charAt(k) == b[j].charAt(l)) {
                count++;
            }
            l++;
            k++;

        }


        return count ;
    }


    //youtube
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Tree trie = new Tree();
        int maxLen = Integer.MIN_VALUE;
        for (int arr : arr1) {
            trie.addWord(Integer.toString(arr));
        }
        for (int arr : arr2) {
            int len = trie.findPrefix(Integer.toString(arr));
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
    

    

    public static void main(String[] args) {
        int[] arr1 = {8};
        int[] arr2 = {48};

        System.out.println(longestCommonPrefix(arr1, arr2));

    }
}


class Node {
    Node child[];

    Node() {
        child = new Node[10]; // o to 9 digits
    }
}

class Tree {
    Node root;

    Tree() {
        root = new Node();
    }

    public void addWord(String word) { // word.len
        Node temp = root;
        for (char ch : word.toCharArray()) { // 123 -> temp => Root, Root.1, Root.1.2, Root.1.2.3
            int index = ch - '0'; // '1' to 1
            // if ch child is not present, then add it
            if (temp.child[index] == null) {
                temp.child[index] = new Node();
            }
            // move to ch child
            temp = temp.child[index];
        }
    }

    // if prefix is present, return prefix otherwise return empty
    public int findPrefix(String word) {
        Node temp = root;
        int len = 0;
        for (int i = 0; i < word.length(); i++) { // 123 -> temp => Root, Root.1, Root.1.2, Root.1.2.3
            char ch = word.charAt(i);
            int index = ch - '0';
            // if ch child is not present, then prefix cannot be found.
            if (temp.child[index] == null) {
                break;
            }
            // move to ch child
            temp = temp.child[index];
            len++;
        }
        return len;

    }

}