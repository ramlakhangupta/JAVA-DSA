import java.util.*;
public class binary {

    // return the index
    // return -1 if the target element does not exist
    public static int binarySearch(int arr[], int target){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            //find the middle element
            
            // int mid = (start + end) / 2 might be possible that (start +end) exceeds the range of java
            int mid = start + (end - start) / 2;    

            if(target < arr[mid]){
                end = mid-1;

            } else if(target > arr[mid]) {
                start = mid +1;

            } else {
                //ans found
                return mid;
            }

        }
        return -1;

    }

    //CHECK THE ARRAY IS ASCENDING SORTED OR DESCENDING SORTED
    public static int orderAgnosticBS(int arr[], int target){
        int start = 0;
        int end = arr.length-1;

        //find whether the array is sorted in decending or asecending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            //find the middle element
            
            // int mid = (start + end) / 2 might be possible that (start +end) exceeds the range of java
            int mid = start + (end - start) / 2;    


            if(arr[mid] == target) {
                return mid;
            }

            if(isAsc){
                 if(target < arr[mid]){
                end = mid-1;
            } else {
                start = mid +1;
                }
            } else {
                if(target < arr[mid]){
                end = mid-1;
                } else{
                    start = mid+1;
                    }
                }

            }
            return -1;

    }
    
    //FIND THE CEILING NO (CEILING  = SMALLEST ELEMENT IN ARRAY GREATER = TARGET)
    public static int ceilingNo(int arr[], int target){

        //but what if the target is greater than the greatest no in the array 
        if(target > arr[arr.length - 1]){
            return -1;
        }


        int start = 0;
        int end = arr.length-1;

        //find whether the array is sorted in decending or asecending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            //find the middle element
            
            // int mid = (start + end) / 2 might be possible that (start +end) exceeds the range of java
            int mid = start + (end - start) / 2;    


            if(arr[mid] == target) {
                return mid;
            }

            if(isAsc){
                 if(target < arr[mid]){
                end = mid-1;
            } else {
                start = mid +1;
                }
            } else {
                if(target < arr[mid]){
                end = mid-1;
                } else{
                    start = mid+1;
                    }
                }

            }
            return arr[start];

    }

    //FIND THE FLOOR NO (FLOOR = GREATEST ELEMENT IN ARRAY SMALLER = TARGET)
    public static int floorNo(int arr[], int target){
        int start = 0;
        int end = arr.length-1;

        //find whether the array is sorted in decending or asecending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            //find the middle element
            
            // int mid = (start + end) / 2 might be possible that (start +end) exceeds the range of java
            int mid = start + (end - start) / 2;    


            if(arr[mid] == target) {
                return mid;
            }

            if(isAsc){
                 if(target < arr[mid]){
                end = mid-1;
            } else {
                start = mid +1;
                }
            } else {
                if(target < arr[mid]){
                end = mid-1;
                } else{
                    start = mid+1;
                    }
                }

            }
            return arr[end];

    }

    //FIND THE SMALLEST LETTER (HERE SMALLEST LETTER HAVE MANY CASES)
    public static char smallestLetter(char[] letters , char target){

        int start = 0;
        int end = letters.length-1;

        while(start <= end){
            //find the middle element
            
            // int mid = (start + end) / 2 might be possible that (start +end) exceeds the range of java
            int mid = start + (end - start) / 2;    

                if(target < letters[mid]){
                    end = mid-1;
                
                } else{
                    start = mid+1;
                    }
                }

            return letters[start % letters.length];

    }
    
    //  // THIS IS INCOMPLETE !!
    // public static int findStartIndex(int arr[], int target){

    //     int[] ans = {-1, -1};


    //     int start = search(arr, target, true);
    //     int end = search(arr, target, false);

    //     ans[0] = start;
    //     ans[1] = end;

    //     return ans;
    // }

    //     //this function just return the index value of target
    //     int search(int[] arr, int target, boolean findStartIndex){
    //         int ans = -1;
    //         int start = 0;
    //         int end = arr.length - 1;
    //         while(start <= end){
    //             //find th middle element
    //             //  int mid = (start +end) / 2; // might be possible that(start+end) expect

    //             int mid = start + (end-start)/2;

    //             if(target < arr[mid]){
    //                 end = mid -1;
    //             }
    //             else if(target >arr[mid]){
    //                 start = mid +1;

    //             } else {
    //                 //potential ans found
    //                 ans = mid;
    //                 if(findStartIndex) {
    //                     end = mid -1;               
    //                  }
    //              else {
    //                 start = mid+1;
    //                 }
    //             }
    //         }   
    //         return ans;
    //     }
   
    

    //IN THIS QUESTION FIND THE TARGET IN INFINITE SIZE OF AN ARRAY 
    public static int InfiniteSize(int[] arr, int target, int start, int end){
         while(start <= end){
            //find the middle element
            
            // int mid = (start + end) / 2 might be possible that (start +end) exceeds the range of java
            int mid = start + (end - start) / 2;    

            if(target < arr[mid]){
                end = mid-1;

            } else if(target > arr[mid]) {
                start = mid +1;

            } else {
                //ans found
                return mid;
            }

        }
        return -1;
    }

    //THIS FUNCTION MADE FOR TO FIND THE LENGTH OF AN ARRAY IN INFINITE SITUATION
    static int ans(int[] arr, int target){
        //first find the range 
        // first start with a box of size of 2

        int start = 0;
        int end = 1;
         
        // condition for the target to lie in this range 
        while(target > arr[end]){
            int temp = end+1;  //this is my new start
            //double th box value
            // end = previous end + sizeOfBox * 2)
            end  = end+(end -start +1)*2;
            start = temp;

        }
        return InfiniteSize(arr, target, start, end);
    }

    // MOUNTAIN NO FIND IN ARRAY
    public static int peakIndexInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int mid = start +(end-start)/2;
            if(arr[mid] > arr[mid+1]){
                //you are in dec part of array
                //this may be the ans, but look at left
                //this is why end != mid-1
                end = mid;
            } else{
                //you are in the asc part of array 
                start = mid+1; // because we know that mid-1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest no because of the 2 checks above
        //start and end are always trying to find max elemnet in the above 2 checks
        //hence, when they are pointing to just one element, that is the max one because that is the max one because tha is the what the checks say
        // more elaboration : at every point of time for start and end , they have the best possible answer till that time 
        //and if we are saying only one item is remaining, hence cuz of line that is the best possible ans 
        return arr[start]; //or return end as both are equal
    }

    // FIND THE PIVOT ELEMENT IN THAT HERE ARE THE 3 WAYS TO FIND THE ANS CASE1(BY FINDPIVOT FUNCTION) , CASE2 (BY SEARCH FUNCTION) , CASE3 (BY BINARYSEARCH2 FUNCTION) 
        //CASE-1
        // WARNING :  THIS WILL NOT WORK FOR DUPLICATE VALUES
        public static int findPivot(int[] arr){
            int start = 0;
            int end = arr.length-1;
            while(start <= end){
            int mid = start +(end-start)/2;
            //4 cases over here
            if(mid < end && arr[mid]> arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[mid] <= arr[start]){
                end = mid-1;
            } else {
                start = mid+1;
            }
            }
            return -1;
        }

        // THIS IS WORKING FOR DUPLICATE VALUE ALSO 
        public static int findPivotWithDuplicates(int[] arr){
            int start = 0;
            int end = arr.length-1;
            while(start <= end){
            int mid = start +(end-start)/2;
            //4 cases over here
            if(mid < end && arr[mid]> arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid] < arr[mid-1]){
                return mid-1;
            }

            //if elements at middle, start, end are equal than just skip the 
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                //skip the duplicates
                //NOTE: what if these elements at start and end were the pivot element 
                //check if start is pivot
                if(arr[start] > arr[start+1]){
                    return start;

                } 
                start++;
                //check whether end is pivot 
                if(arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            }
            //left side is sorted so pivot should be in right side
            else if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
                start = mid+1;
            } else{
                end = mid-1;
            }
            }
            return -1; 
        }
    
        //CASE-2
        public static int binarySearch2(int arr[], int target, int start, int end){
            while(start <= end){
            //find the middle element
            
            // int mid = (start + end) / 2 might be possible that (start +end) exceeds the range of java
            int mid = start + (end - start) / 2;    

            if(target < arr[mid]){
                end = mid-1;

            } else if(target > arr[mid]) {
                start = mid +1;

            } else {
                //ans found
                return mid;
            }

            }
            return -1;

        }

        //CASE-3
    static int search(int[] arr, int target){
        int pivot = findPivot(arr);

        //if you didnot find a pivot , it means the array is not rotated
        if(pivot == -1){
            //just do normal binary search
            return binarySearch2(arr, target, 0, arr.length-1);
        }
        // if pivot is found , you have found 2 asc sorted arrays
        if(arr[pivot] == target){
            return pivot;
        }
        if(target >= arr[0]){
            return binarySearch2(arr, target, 0, pivot-1);
        }
        return binarySearch2(arr, target, pivot+1, arr.length-1);
    }

    // ROTATION COUNT (HOW MANY TIMES ARRAY IS ROTATED LIKE {14,15,18,2,3,4} HERE THIS ARR IS ROTATED 3 TIMES)
    public static int rotationCount(int[] arr){
        int pivot = findPivot(arr);
       return pivot +1;
    }

    // SPLIT ARRAY QUESTION GOOGLE ASKED !
    public static int splitArray(int arr[], int m){
        int start = 0;
        int end = 0;
         
        for(int i = 0; i<arr.length; i++){
            start = Math.max(start, arr[i]); // in the end of the loop this will contain max item from the array
            end += arr[i];

        }

        // binary search
        while(start < end){
            //try for the middle as potential ans 
            int mid = start + (end - start)/ 2;

            //calculate how many you can divide this in with this max sum 
            int sum = 0;
            int piece = 1;
            for(int num : arr ){
                if(sum + num > mid){
                    //you can  add this in this subarray , make the new one
                    // say you add this num in new subarray, then sum  = arr
                    sum = num;
                    piece++;
                } else {
                    sum += num;
                }
            }
            if(piece > m){
                start = mid+1;

            } else {
                end = mid;
            }
        }
        return end; // here start == end
    }

    //2D ARRAY 
    public static int FindNo(int arr[][], int target){
        for(int row =0;row<arr.length;row++){
            for(int col=0; col<arr[row].length;col++){
                if(arr[row][col] == target){
                    return row*col;
                } 
            }
        }
         return -1;
    }

    public static void main(String args[]){
        int arr[][] = { {18,9,12}, {36,-4,91}, {44,33,16} };
        int target = 91;
        System.out.println(FindNo(arr,target));
    }
}
