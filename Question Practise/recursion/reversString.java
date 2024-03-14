public class reversString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverse(s);
    }
    public static void reverse(char[] s){
         System.out.println(revers(s,0,s.length-1));
    }

    private static char[] revers(char[] mix, int start, int end) {
        
        if(start>end){
            return mix;
        } 
            while(end>start){
            char temp = mix[start];
            mix[start] = mix[end];
            mix[end] = temp;
            return revers(mix, start+1, end-1);
        }
        return mix;
            
        
        
    }
}