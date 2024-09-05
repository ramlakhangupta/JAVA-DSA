import java.util.*;



public class walkingRobotSimulation874 {

    public static int robotSim(int[] commands, int[][] obstacles) {
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        HashSet<String> set = new HashSet<>();

        for (int[] ele : obstacles) {
            set.add(ele[0] + " " + ele[1]);
        }

        int x = 0, y = 0, dir = 0;
        int max = 0;

        for (int  command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4;
            } else if(command == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int newX = x + direction[dir][0];
                    int newY = y + direction[dir][1];

                    if (!set.contains(newX + " " + newY)) {
                        x = newX;
                        y = newY;
                        max = Math.max(max, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4,-1,4,-2,4};
        int[][] arr2 = {{2,4}};
        System.out.println(robotSim(arr,arr2));
    }
}
