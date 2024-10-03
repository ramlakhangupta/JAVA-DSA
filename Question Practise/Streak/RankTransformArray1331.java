/**
 * RankTransformArray1331
 */

 import java.util.*;
public class RankTransformArray1331 {

    public static int[] arrayRankTransform(int[] arr) {
        
        int[] sortarr = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            sortarr[i] = arr[i];
        } 
        int value = 0;
        Arrays.sort(sortarr);
        int[] ans = new int[arr.length];
        int[] index = new int[sortarr.length];
        for (int i = 0; i < sortarr.length; i++) {
            if(i<sortarr.length-1 && sortarr[i] == sortarr[i+1]){
                index[i] = value;
            }
            else {
                index[i] = value+1;
                value++;
            }
        }


        for(int i=0; i<sortarr.length; i++){
            int j=0;
            while(arr[i] != sortarr[j]){
                j++;
            }
            ans[i] =  index[j];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        System.out.println(arrayRankTransform(arr));
    }
}