public class minimumArrayEnd3133 {
    

    public long minEnd(int n, int x) {
        long result = x;
        long position = 1;
        long remaining = n-1;

        while(remaining != 0){
            if((x & position) == 0){
                result |= (remaining & 1) * position;
                remaining >>= 1;
            }
            position <<= 1;
        }
        
        return result;
    }

    //Approach - Simple using AND and OR
    //T.C : O(n)
    //S.C : O(1)
    public long minEnd1(int n, int x) {
        long num = x;

        for (int i = 1; i < n; i++) {
            // Increment num and perform bitwise OR with x
            num = (num + 1) | x;
        }

        return num;
    }
}

