public class LexicographicalNo386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            solve(i, n, list);
        }
        return list;
    }

    public void solve(int val, int n, List<Integer> list) {
        if (val > n) {
            return;
        }

        list.add(val);
        for (int i = 0; i <= 9; i++) {
            int next = val * 10 + i;
            if (next > n) {
                break;
            }
            solve(next, n, list);
        }
    }
}