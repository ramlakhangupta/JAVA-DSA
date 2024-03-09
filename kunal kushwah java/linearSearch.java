import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int arr[] = {3,2,1,18,18,9};
        // System.out.println(searchByIndex(arr,0 ,18));
        // System.out.println(search(arr, 0, 18));
        // System.out.println(findIndexLast(arr, arr.length-1, 18));
        // findAllIndex(arr, 0, 18);
        // System.out.println(list);
        ArrayList<Integer> ans = findAllIndexByArrayList(arr, 0, 18, new ArrayList<>());
        System.out.println(ans);
    }


    // // its to find index of target
    // static int searchByIndex(int[] arr, int i, int target){
    //     if(i == arr.length){
    //         return -1;
    //     }
    //     if(arr[i] == target){
    //         return i;
    //     }
    //     return searchByIndex(arr, i+1, target);
    // }

    // // by the boolean type
    // static boolean search(int[] arr, int i, int target){
    //     if(i == arr.length){
    //         return false;
    //     }
    //     return arr[i] == target || search(arr, i+1, target);
    // }


    // // its start at last an array 
    // static int findIndexLast(int[] arr, int i, int target){
    //     if(i == -1){
    //         return -1;
    //     }
    //     if(arr[i] == target){
    //         return i;
    //     }
    //     return findIndexLast(arr, i-1, target);
    // }


    // //if you have two same no in the array then print both index use arraylist 
    // static ArrayList<Integer> list = new ArrayList<>();
    // static void findAllIndex(int[] arr, int i , int target){
    //     if(i == arr.length){
    //         return ;
    //     }
    //     if(arr[i] == target){
    //         list.add(i);
    //     }  
    //     findAllIndex(arr, i+1, target);
        
    // }


    static ArrayList<Integer> findAllIndexByArrayList(int[] arr, int i , int target, ArrayList<Integer> list){
        if(i == arr.length){
            return list;
        }
        if(arr[i] == target){
            list.add(i);
        }  
        return findAllIndexByArrayList(arr, i+1, target, list);
        
    }
}
