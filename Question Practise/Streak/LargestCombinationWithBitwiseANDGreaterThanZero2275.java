public class LargestCombinationWithBitwiseANDGreaterThanZero2275 {
    public int largestCombination1(int[] candidates) {
     
        int result = 0;
        int[] count = new int[24];

        for(int i=0; i<24; i++){
            for(int num : candidates){
                if((num & (int)Math.pow(2, i)) != 0){
                    count[i]++;
                }
            }
            result = Math.max(result, count[i]);
        }
        return result;
    }


    public int largestCombination2(int[] candidates) {
        int[] count = new int[24];
        int result = 0;

        // Count how many numbers have the i-th bit set
        for (int i = 0; i < 24; i++) { // O(24)
            for (int num : candidates) { // O(n)
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
            result = Math.max(result, count[i]);
        }

        return result;
    }


    public static int largestCombination(int[] candidates) {
        int result = 0;

        for (int i = 0; i < 24; i++) { // O(24)
            int countIth = 0;

            for (int num : candidates) { // O(n)
                System.out.print((1 << i));
                System.out.println((num & (1 << i)));
                if ((num & (1 << i)) != 0) {
                    countIth++;
                }
                System.out.println();
            }

            result = Math.max(result, countIth);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {16,17,71,62,12,24,14};
        System.out.println(largestCombination(arr));
    }


}
