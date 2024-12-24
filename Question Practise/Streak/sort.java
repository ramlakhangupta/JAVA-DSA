import java.util.*;

public class sort{

    //BUBBLE SORT ALPHA
    public static void bubbleSort(int arr[]){
        for(int turn = 0; turn<arr.length-1;turn++){
            
            for(int j=0;j<arr.length-1-turn; j++){
                if(arr[j] > arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
     
    //FOR PRINTING 
    public static void printArr(int arr[]){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //SELECTION SORT ALPHA
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minPos = i;
            for(int j = i+1; j<arr.length;j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    //INSERTION SORT ALPHA
    public static void insertionSort(int arr[]){
        for(int i=0; i<arr.length;i++){
            int curr =  arr[i];
            int prev = i-1;

            //finding out the correct pos to insert
            while(prev>=0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1] = curr;
        }
    }

    //COUNTING SORT ALPHA
    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length;i++){
            count[arr[i]]++;
        }

        //sorting
        int j = 0;
        for(int i=0;i<count.length;i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    //SELESCTION SORT CODE
    public static void selection(int[] arr){
        for(int i=0; i<arr.length;i++){
            //find the max item in the remaining array amd swap with correct index
            int last = arr.length-i-1;
            int maxIndex = getMaxIndex(arr,0,last);
            swap(arr,maxIndex,last);
        }
    }

    //SWAP CODE
    static void swap(int[] arr,int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }

    //GET MAX INDEX 
    static int getMaxIndex(int[] arr,int start, int end){
        int max = start;
        for(int i = start; i<=end; i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }

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
    
   

    
    public static void main(String args[]){
     int[][] accounts = [[1,2,3],[3,2,1]]
     System.out.println(maximumWealth(accounts));
    }
}