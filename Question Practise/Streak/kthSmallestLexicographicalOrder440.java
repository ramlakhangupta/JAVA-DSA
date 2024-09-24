import java.util.ArrayList;
import java.util.List;

public class kthSmallestLexicographicalOrder440 {

    //optimized
    public static int findKthNumber(int n, int k) {
        int prefix = 1; // Start with prefix 1
        k--; // We subtract 1 because we treat the first number (1) as the 0th
        
        while (k > 0) {
            // Count the number of nodes between prefix and prefix + 1 in the tree
            long count = countSteps(prefix, n);
            
            if (count <= k) {
                // If the Kth number is not in this subtree, move to the next prefix
                k -= count;
                prefix++;
            } else {
                // If the Kth number is in this subtree, go deeper by multiplying prefix by 10
                prefix *= 10;
                k--;
            }
        }
        
        return prefix;
    }

    // Helper function to count the number of lexicographical numbers between current and current + 1
    private static long countSteps(int prefix, int n) {
        long steps = 0;
        long first = prefix;
        long last = prefix;
        
        while (first <= n) {
            steps += Math.min(n + 1, last + 1) - first;
            first *= 10;
            last = last * 10 + 9;
        }
        
        return steps;
    }

    //brute force
    public int findKthNumber1(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i< 10 ; i++){
            dfs(i,n,list);
        }
        
        return list.get(k-1);
    }

    public void dfs(int current, int n, List<Integer> list){
        if(current > n){
            return;
        }
        list.add(current);
        for(int i=0; i< 10 ; i++) {
            int num =  current*10+i;
            if(num > n){
                return ;
            }
            dfs(num,n,list);
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 2));
    }
}
