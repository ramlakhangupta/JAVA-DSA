import java.util.Arrays;

public class MinimizedMaxmOfProductDistributedToAnyStore {

    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int start = 1;
        int end = position[n - 1] - position[0];
        int result = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(position, m, mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;

            }
        }
        return result;
    }

    public boolean isPossible(int[] position, int m, int mid) {
        int prev = position[0];
        int count = 1;

        for (int i = 0; i < position.length; i++) {
            int curr = position[i];

            if (curr - prev >= mid) {
                count++;
                prev = curr;
            }

            if (count == m) {
                break;
            } else if(count > m) {
                return false;
            }

        }
        return count == m;
    }
}