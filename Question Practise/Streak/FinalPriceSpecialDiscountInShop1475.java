public class FinalPriceSpecialDiscountInShop1475 {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j = i+1; j<n; j++){
                if(prices[i] >= prices[j]){
                    temp = prices[j];
                    break;
                }
            }
            ans[i] = prices[i]-temp;
        }
        return ans;
    }
    
}
