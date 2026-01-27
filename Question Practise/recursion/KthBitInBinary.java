public class KthBitInBinary {
    public static void main(String[] args) {
       System.out.println(findKthBit(4,11));
    }
    public static char findKthBit(int n, int k) {
        if(n == 1 ) return '0';
    
        int l = (int) Math.pow(2,n) -1;
        int mid = l/2 +1;
        if(k == mid) return '1';
        else if (k < mid ) return findKthBit(n-1, k);
                else return findKthBit(n-1, l+1-k) == '0' ? '1' : '0';
    }
}

