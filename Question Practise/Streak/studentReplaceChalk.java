public class studentReplaceChalk {

    public static int chalkReplacer(int[] chalk, int k) {
        int count = 0;
        while(k >= chalk[count]){
            k = k - chalk[count];
            count +=1;
            if(count >= chalk.length ){
                count = 0;
            }
            
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,5};
        int ans = chalkReplacer(arr, 25);
        System.out.println(ans);
    }
}
