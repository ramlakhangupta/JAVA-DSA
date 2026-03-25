class Solution {
    int ans = Integer.MAX_VALUE;

    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = Arrays.stream(piles).max().getAsInt();

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (isPossible(piles, mid, h)) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] piles, int mid, int h) {
        int n = piles.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (piles[i] + mid - 1) / mid;
        }

        if (count <= h) {
            ans = Math.min(mid, ans);
            return true;
        }

        return false;
    }
}
