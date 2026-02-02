
class CountDigit {
    public static int evenlyDivides(int N){
        // code here
        int copy = N;
        int count = 0;
        while(copy != 0){
            int a = copy%10;
            if(a != 0 && N%a == 0) count++;
            copy /= 10;
        }
        return count;
    }
}

