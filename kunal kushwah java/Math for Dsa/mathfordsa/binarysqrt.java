public class binarysqrt {
    public static void main(String[] args) {
        int n = 40;
        int p = 3;
        
        System.out.printf("%.3f", sqr(n, p));
    }

    //THIS CODE IS BASED ON BINARY SEARCH 
    //IN THIS CODE WE CAN TAKE ONLY PART 2 BY THAT OUR CODE IS ALSO RUNNNING 
    //TIME COMPLEXITY = 0(logn)
    public static double sqr(int n, int p) {

        //PART1 IS BASED ON THE BINARY SEARCH
        int s = 0;
        int e = n;

        double root = 0.0;

        while (s<=e){
            int m = s +(e-s)/2;

            if(m*m == n){
                return m;
            }

            if(m*m > n){
                e = m-1;
            } else {
                s= m+1;
            }
        }


        //PART2 REFERS THE FIND SQRT PRECISELY AFTER 2 TO 3 DECIMAL POINTES.
        double incr = 0.1;
        for(int i=0;i<p;i++){
            while(root*root <= n){
                root += incr;
            }

            root -= incr;
            incr /= 10;

            
        }

        return root;
    }
       
}
