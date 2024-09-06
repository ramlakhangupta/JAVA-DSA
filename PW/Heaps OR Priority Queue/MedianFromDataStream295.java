import java.util.*;



//BRUTE FORCE : TC : O(n^2 logn)
class MedianFinder1 {
    ArrayList<Integer> list = new ArrayList<>();


    public MedianFinder1() {
        
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        int n = list.size();
        if ( n%2 != 0) {
            return list.get(n/2);
        } else {
            return ( list.get( n/2 ) + list.get ( n/2 - 1 ) ) / 2.0 ;
        }
    }
}


//TO reduce the time complexity we have to optimize our sorting, it means when we add the item 
//then the list is already sorted and but we insert element in unsorted list so we have to use INSERTION SORT ALGO.

// TC : O(n^2)
class MedianFinder2 {
    ArrayList<Integer> list = new ArrayList<>();


    public MedianFinder2() {
        
    }
    
    public void addNum(int num) {
        list.add(num);
        int i = list.size() - 1;
        while (i>0) {
            if (list.get(i) < list.get(i-1)) {
                swap(i, i-1);
                i -= 1;
            } else {
                break;
            }
        }
    }
    
    public void swap(int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, list.get(temp));

    }

    public double findMedian() {
        
        int n = list.size();
        if ( n%2 != 0) {
            return list.get(n/2);
        } else {
            return ( list.get( n/2 ) + list.get ( n/2 - 1 ) ) / 2.0 ;
        }
    }
}


//Best Solution : Using Heaps



class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    


    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (left.size() == 0) {
            left.add(num);
        } else {
            if (num < left.peek()) {
                left.add(num);
            } else {
                right.add(num);
            }
        }

        //Balance the Heap
        if (left.size() == right.size() + 2) {
            right.add(left.remove());
        }
        if (left.size() + 2 == right.size()) {
            left.add(right.remove());
        }
    }
     
    
    public double findMedian() {
       
        if (left.size() ==  right.size()){
            return (left.peek()+right.peek())/2.0;
         } 
        else if (left.size() > right.size()) {
            return left.peek();
        }
            
        else { 
            return right.peek();
        } 
    }
       
}

 
    













public class MedianFromDataStream295 {
    
}
