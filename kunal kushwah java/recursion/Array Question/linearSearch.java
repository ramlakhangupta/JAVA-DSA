import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int arr[] = {3,2,1,18,18,9};
        System.out.println(searchByIndex(arr,0 ,18));
        System.out.println(search(arr, 0, 18));
        System.out.println(findIndexLast(arr, arr.length-1, 18));
        findAllIndex(arr, 0, 18);
        System.out.println(list);
        ArrayList<Integer> ans = findAllIndexByArrayList(arr, 0, 18, new ArrayList<>());
        System.out.println(ans);

        
        System.out.println(findAllIndex2(arr, 0, 18));
    }


    // its to find index of target
    static int searchByIndex(int[] arr, int i, int target){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == target){
            return i;
        }
        return searchByIndex(arr, i+1, target);
    }

    // by the boolean type
    static boolean search(int[] arr, int i, int target){
        if(i == arr.length){
            return false;
        }
        return arr[i] == target || search(arr, i+1, target);
    }


    // its start at last an array 
    static int findIndexLast(int[] arr, int i, int target){
        if(i == -1){
            return -1;
        }
        if(arr[i] == target){
            return i;
        }
        return findIndexLast(arr, i-1, target);
    }


    //if you have two same no in the array then print both index use arraylist 
    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int i , int target){
        if(i == arr.length){
            return ;
        }
        if(arr[i] == target){
            list.add(i);
        }  
        findAllIndex(arr, i+1, target);
        
    }


    static ArrayList<Integer> findAllIndexByArrayList(int[] arr, int i , int target, ArrayList<Integer> list){
        if(i == arr.length){
            return list;
        }
        if(arr[i] == target){
            list.add(i);
        }  
        return findAllIndexByArrayList(arr, i+1, target, list);
        
    }


    static ArrayList<Integer> findAllIndex2(int[] arr, int i , int target){

        ArrayList<Integer> list = new ArrayList<>();

        if(i == arr.length){
            return list;
        }

        //this will contain answer for that function call only 
        if(arr[i] == target){
            list.add(i);
        }  

        // program is running on only line 91 till all conditions cant executed after iteration over and line 82 is executed then ansFromBelowCalls function has value one by one
        
        ArrayList<Integer> ansFromBelowCalls = findAllIndex2(arr, i+1, target);

        //then it goes to line 94 in this addAll function added the value of every iteration after it return a list to main function.
        list.addAll(ansFromBelowCalls);

        return list;
        
    }
}
