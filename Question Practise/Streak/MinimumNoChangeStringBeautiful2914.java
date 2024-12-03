public class MinimumNoChangeStringBeautiful2914 {
    public static int minChanges1(String s) {
        int count1 = 0;
        int count2 = 0;
        int len = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1' && count2%2 == 0 ){
               
                count1++;
                continue;
            } else {
                if(count1%2 != 0){
                    len++;
                    count1++;
                    
                    continue;
                }  else {
                    count1 = 0;
                }
                
            } 
            
            if(s.charAt(i) == '0' && count1 %2 ==  0 ){
               
                count2++;

            } else {
                if(count2 %2 != 0){
                    len++;
                   count2++;
                } else {
                    count2 = 0;
                }
                
            }

        }
        return len;
    }


    //Approach-1 (Simple iterate and count and keep track)
    //T.C : O(n)
    //S.C : O(1)
    public static int minChanges(String s) {
        char curr = s.charAt(0);

        int count = 0;
        int changes = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            
            if (s.charAt(i) == curr) {
                count++;
                continue;
            }

            if (count % 2 == 0) {
                count = 1;
            } else {
                count = 0;
                changes++;
            }
            curr = s.charAt(i);
        }

        return changes;
    }



    //Approach-2 (Simple iterate and count and keep track)
    //T.C : O(n)
    //S.C : O(1)
    public static int minChanges2(String s) {
        int changes = 0;
        int n = s.length();

        for (int i = 0; i < n - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }

        return changes;
    }

    public static void main(String[] args) {
        System.out.println(minChanges("010010"));
    }
}
