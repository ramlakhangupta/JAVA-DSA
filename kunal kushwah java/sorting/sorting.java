import java.util.*;
public class sorting
{

    //BUBBLE SORT
    static void bubble(int[] arr){
       boolean swapped;
        //run the steps n-1 time 
        for(int i = 0;i<arr.length;i++){
            swapped = false;
            // for each step ,max item will come at the last respective index
            for(int j = 1; j<arr.length-i;j++){
                //swap if the item is smaller than the previous item 
                if(arr[j]<arr[j-1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
           //if you did not swap for a particular value of i , it means the array is sorted hence stop the loop 
           if(!swapped){
            break;
           }

        }
    }

    //SELECTION SORT
    public static void selection(int[] arr){
        for(int i=0; i<arr.length;i++){
            //find the max item in the remaining array and swap with correct index
            int last = arr.length-i-1;
            int maxIndex = getmaxIndex(arr,0,last);
            swap(arr,maxIndex,last);

        }
    }

    //SWAP
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    //GET MAX INDEX
    static int getmaxIndex(int[] arr, int start, int end){
        int max = start;
        for(int i = start; i<=end;i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }

    //INSERTION SORT
    static void insertion(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1; j>0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                    }
                        else{
                            break;
                        }
                    
                
            }
        }
    }

    //CYCLIC SORT  
    static void cyclic(int[] arr){
        for(int i=0;i<arr.length;i++){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
    }

    //PROBLEMS

        public static void missingNumber(int[] arr){
            int i=0;
            while(i<arr.length){
                int correct = arr[i];
                if(arr[i] < arr.length && arr[i] != arr[correct]){
                    swap(arr, i, correct);
                }
                else{
                    i++;
                }
            }

            // search for first missing no
            for(int index = 0; index < arr.length; index++){
                if(arr[index] != index){
                    return index;
                }
            }

            //case 2
            return arr.length;
        }

        //FIND ALL MISSING NUMBERS
        public List<Integer> findAllMissingNumber(int[] nums){
            int i=0;
            while(i < nums.length){
                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]){
                    swap(nums, i, correct);
                
                } else{
                    i++;
                }
            }
            //just find missing numebrs
            List<Integer> ans = new ArrayList<>();
            for(int index = 0; index < nums.length; index++){
                if(nums[index] != index+1){
                    ans.add(index+1);
                }
            }
            return ans;
            System.out.print(ans);
        }

        //DUPLICATE NUMBER
        public int duplicate(int[] arr){
            int i=0;
            while(i < arr.length){

                if(arr[i] != i+1){
                     int correct = arr[i] - 1;
                if(arr[i] < arr[correct]){
                    swap(arr, i, correct);
                }
                 else{
                  return arr[i];
                } else{
                    i++;
                }

               
                
               
            }
            return -1;
        }
     public static void main(String args[]){
        int[] nums = {4, 0, 2, 1};
        duplicate();
    }
}