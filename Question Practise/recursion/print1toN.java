public class print1toN {
    public static void main(String[] args) {
        int n = 10;
        no(n,1);
    }

    private static int no(int n,int i) {
    
        if(n<i){
            return 0;
        } else{
            System.out.println(i);
        }

        
        return no(n,i+1);
    }

    
}
