public class minimumBitFlipsToConvertNo2220 {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;
        while(xor>0){
            xor &= (xor-1); // for removes 1 & to find the total no of flips
            count++ ;
        }
        return count;
    }
}
