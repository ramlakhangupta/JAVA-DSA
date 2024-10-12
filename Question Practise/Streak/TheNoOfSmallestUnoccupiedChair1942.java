import java.util.*;
import java.util.PriorityQueue;

public class TheNoOfSmallestUnoccupiedChair1942 {

    public int smallestChair1(int[][] times, int targetFriend) {
        int n = times.length;
        int[] chair = new int[n];
        Arrays.fill(chair, -1);
        int targetFriendArrivalTime = times[targetFriend][0];

        Arrays.sort(times, (a,b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int arrival = times[i][0];
            int departure = times[i][1];

            for (int j = 0; j < n; j++) {
                if (chair[j] <= arrival) {
                    chair[j] = departure;

                    if (arrival == targetFriendArrivalTime) {
                        return j;
                    }
                    break;
                }
            }
        }
        return -1;
    }


    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        //sort based in arrival time
        PriorityQueue<Integer> freeHeap = new PriorityQueue<>();
        PriorityQueue<int[]> occupiedHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int targetFriendArrivalTime = times[targetFriend][0];

        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        int chairNo = 0;

        for (int i = 0; i < n; i++) {
            int arrival = times[i][0];
            int departure = times[i][1];

            while (!occupiedHeap.isEmpty() && occupiedHeap.peek()[0] <= arrival) {
                freeHeap.offer(occupiedHeap.poll()[1]);
            }

            if (freeHeap.isEmpty()) {
                //no free chairs, assign a new one
                occupiedHeap.offer(new int[] {departure, chairNo});

                if (arrival == targetFriendArrivalTime) {
                    return chairNo;
                }
                chairNo++;

            } else {
                int leastChairAvailable = freeHeap.poll();

                if (arrival == targetFriendArrivalTime ) {
                    return leastChairAvailable;
                }

                occupiedHeap.offer(new int[] {departure,leastChairAvailable});
            }
        }
        return -1;
    }

}