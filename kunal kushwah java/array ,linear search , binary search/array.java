import java.util.*;

public class array{
    

    //search in the array : return the index if the found
    // otherwise if item not found return -1
    public static int linearSearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        for(int i=0; i<arr.length; i++){
            //check for element at every index if it is = target
            int element = arr[i];
            if(element == target)
            {
                return i;
            }
        }
        //this line will execute if none of the return statements above have executed
        //hence the target not found
        return -1;
    }



     //Linear Search in Array
    //search in the array : return the index if the found
    // otherwise if item not found return -1
    public static int linearSearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        for(int i=0; i<arr.length; i++){
            //check for element at every index if it is = target
            int element = arr[i];
            if(element == target)
            {
                return i;
            }
        }
        //this line will execute if none of the return statements above have executed
        //hence the target not found
        return -1;
    }

    //SEARCH IN STRING
    public static boolean search(String str, char target){
        if(str.length() == 0){
            return false;
        }
        for(int i=0; i<str.length();i++){
            if(target == str.charAt(i)){
                return true;
            }
        }
        return false;
    }
    
    //SEARCH IN RANGE 
    public static int SearchInRange(int[] arr, int target, int start, int end){
        if(arr.length == 0){
            return -1;
        }

        for(int i = start; i<=end;i++){
            //check for element at every index if it is = target
            int element = arr[i];
            if(element == target){
                return i;
            }
        }
        return -1;
    }

    //MINIMUM NUMBER
    // assume arr.length != 0
    // return the minimum value in the array
    public static int minimumNumber(int arr[]){
       int ans = arr[0];
        for(int index = 1; index <arr.length; index++){
            if(arr[index]<ans){
                ans = arr[index];
            }
        }
        return ans;
    }

    //EVEN DIGITS QUESTION BY LEETCODE
    public static int findNumber(int[] nums){
        int count = 0;
        for(int num : nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }
        //function to check whether a number contains even digits or not
        static boolean even(int num){
            int numberOfDigits = digits(num);
            if(numberOfDigits % 2 == 0){
                return true;
            }
            return false;
        }

        //count number of digits in a number
        static int digits(int num){
            int count = 0;
            while(num>0){
                count++;
                num = num/10;
            }
            return count;
        }
    
    //RICHEST CUSTOMER WEALTH
    public static int maximumWealth(int[][] accounts){
        //i=person = row
        //j=account = col
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<accounts.length;i++){
            //when you start a new col, take a new sum for that
            int sum = 0;
            for(int j=0; j<accounts[i].length;j++){
                sum += accounts[i][j];
            }
            //now we have sum of accounts of person
            //check with overall ans
            if(sum>ans){
                ans = sum;
            }
        }
        return ans;
    }


    
    public static void main(String args[]){
        int[] arr = {23, 45, 1, 2, 8, 19, -3, 16, -11, 28};
        int target  = 19;
        int ans = linearSearch(arr, target);
        System.out.println(ans);
    }

}