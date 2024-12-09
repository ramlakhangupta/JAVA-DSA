import java.util.Arrays;

public class KokoEatingBananas875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = Arrays.stream(piles).max().getAsInt();
        int result = 0;
        while(s <= e){
            int mid = s+(e-s)/2;
            if(isPossible(piles, mid, h)){
                result = mid;
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return result;
    }

    public static boolean isPossible(int[] piles, int mid, int h){
        int count = 0;
        for(int pile : piles){
            if(pile % mid == 0){
                count += pile / mid;
            } else {
                count += pile / mid+1;
            }
            if(count > h){
                return false;
            }
        }
        return count <= h;
    }


    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println(minEatingSpeed(piles, h));
    }
}
